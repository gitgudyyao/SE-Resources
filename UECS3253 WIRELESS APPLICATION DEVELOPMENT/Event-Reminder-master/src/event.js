import React , {Component} from 'react';
import { View, StyleSheet, Keyboard,Dimensions} from 'react-native'
import DatePicker from 'react-native-datepicker'
import {Formik} from 'formik'
import {TextInput, Button,Provider as PaperProvider,withTheme,FAB,Switch,TouchableRipple,Text} from 'react-native-paper'
import AsyncStorage from '@react-native-community/async-storage';
import type { Theme } from 'react-native-paper'
import RNCalendarEvents from 'react-native-calendar-events'

class Event extends Component{
    constructor(props){
        super(props)
        var empty = [{
            name:'',
            time:'',
            id:''
        }];
        this.state = {
            events: JSON.stringify(empty),
            selectedEvent: empty,
            name: '',
            startDate: '',
            endDate: '',
            id:'',
            calendarEventID: '',
            alarm: false,
            visible: false,
            alarmOffset: '',
            calendars: '',
        }
        
    }

    static navigationOptions = {
        title:"Event Details"
    };

    async componentDidMount(){
        await AsyncStorage.getItem('events').then(value => {this.setState({'events': value})});
        var { navigation } = this.props;
        var eventID = JSON.stringify(navigation.getParam('eventID', '0'));
        this.setState({ selectedEvent: (JSON.parse(this.state.events))[eventID]});
        this.setState({name: this.state.selectedEvent.name});
        this.setState({startDate: this.state.selectedEvent.startDate});
        this.setState({endDate: this.state.selectedEvent.endDate});
        this.setState({id: this.state.selectedEvent.id});
        this.setState({calendarEventID: this.state.selectedEvent.calendarEventID});
        this.setState({alarm:this.state.selectedEvent.alarm});
        this.setState({visible:this.state.selectedEvent.alarm});
        this.setState({alarmOffset:this.state.selectedEvent.alarmOffset});
    }

    async submit(values){
        var parsed = JSON.parse((this.state.events));
        parsed[this.state.selectedEvent.id].name = values.name;
        parsed[this.state.selectedEvent.id].startDate = values.startDate;
        parsed[this.state.selectedEvent.id].endDate = values.endDate;
        parsed[this.state.selectedEvent.id].alarmOffset = values.alarmOffset;
        parsed[this.state.selectedEvent.id].alarm = this.state.alarm;
        
        await RNCalendarEvents.findCalendars().then(
            value => {
                this.setState({'calendars':value});
            }
        );
        const selectedCalendarID = await AsyncStorage.getItem('selectedCalendarID');

        if(this.state.alarm){
            await RNCalendarEvents.saveEvent(values.name, {
                calendarId: selectedCalendarID,
                id: this.state.calendarEventID,
                startDate: (new Date(values.startDate)).toISOString(),
                endDate: (new Date(values.endDate)).toISOString(),
                alarms: [{
                    date: Number(values.alarmOffset) * 60
                }]
            });

        }else{
            await RNCalendarEvents.saveEvent(values.name, {
                calendarId: selectedCalendarID,
                id: this.state.calendarEventID,
                startDate: (new Date(values.startDate)).toISOString(),
                endDate: (new Date(values.endDate)).toISOString(),
                alarms:[]
            });
        }
        await AsyncStorage.setItem('events',JSON.stringify(parsed));
    }

    render(){
        const {
            theme: {
                colors: {background},
            },
        } = this.props;
        const width = Dimensions.get('window').width;
        return (
            <View style = {{flex:1, backgroundColor: background}}>
                <Formik
                    enableReinitialize

                    initialValues = {{
                        name: this.state.name,
                        startDate: this.state.startDate,
                        endDate: this.state.endDate,
                        alarmOffset: this.state.alarmOffset,

                    }}

                    onSubmit = {values => {
                        this.submit(values);
                        Keyboard.dismiss();
                        this.props.navigation.navigate('EventList');
                    }}
                >
                    {({handleChange, handleSubmit, values}) => (
                        <View style = {{flex:1, backgroundColor: background}}>
                            <TextInput
                                style={{height: 60}}
                                onChangeText = {handleChange('name')}
                                value = {values.name}
                                label="Event Name"
                                placeholder="Wireless App Assignment due date"
                                mode="outlined"
                            />
                            <DatePicker
                                style={{width: width,height: 60}}
                                date={values.startDate}
                                mode="datetime"
                                placeholder="select event start date"
                                format="LLL"
                                minDate="2019-01-01"
                                maxDate="2030-12-31"
                                customStyles={{
                                dateInput: {
                                    marginTop: 15,
                                    height: 50,
                                    borderRadius: 5
                                },
                                dateText:{
                                    color:'white'
                                }
                                }}
                                onDateChange={handleChange('startDate')}
                            />
                            
                            <DatePicker
                                style={{width: width,height: 60}}
                                date={values.endDate}
                                mode="datetime"
                                placeholder="select event end date"
                                format="LLL"
                                minDate="2019-01-01"
                                maxDate="2030-12-31"
                                customStyles={{
                                dateInput: {
                                    marginTop: 15,
                                    height: 50,
                                    borderRadius: 5
                                },
                                dateText:{
                                    color:'white'
                                }
                                }}
                                onDateChange={handleChange('endDate')}
                            />

                            <TouchableRipple 
                            style={{height: 60}}
                            onPress = {() =>{ this.setState({ 'alarm': !this.state.alarm }); this.setState({'visible': !this.state.visible});} }>
                            <View style={{height: 60}} style={styles.preference}>
                                <Text>Alarm</Text>
                                <View pointerEvents="none">
                                    <Switch value={this.state.alarm}
                                            onValueChange={() =>
                                                { this.setState({ 'alarm': !this.state.alarm }); }
                                            }
                                     />
                                </View>
                            </View>
                            </TouchableRipple>

                            {this.state.visible && <TextInput
                                style={{height: 60}}
                                onChangeText = {handleChange('alarmOffset')}
                                value = {values.alarmOffset}
                                label="Alarm offset (In hours)"
                                mode="outlined"
                                keyboardType="numeric"
                            />}

                            <FAB
                                style={styles.fab}
                                icon="done"
                                onPress = {handleSubmit}
                            />
                        </View>
                    )}
                </Formik>
            </View>
        )
        
    }
    
}

const styles = StyleSheet.create({
    fab: {
        position: 'absolute',
        margin: 16,
        right: 0,
        bottom: 0,
    },preference: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        paddingTop: 15,
        paddingHorizontal: 16,
      },
})

export default withTheme(Event);