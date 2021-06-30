import React, { Component } from 'react'
import { View,StyleSheet,Keyboard,Dimensions,Alert} from 'react-native'
import {Formik} from 'formik'
import {TextInput,withTheme,FAB,Switch,Text,TouchableRipple} from 'react-native-paper'
import DatePicker from 'react-native-datepicker'
import AsyncStorage from '@react-native-community/async-storage';
import type { Theme } from 'react-native-paper'
import RNCalendarEvents from 'react-native-calendar-events'

class AddEvent extends Component{
    
    constructor(props){
        super(props)
        this.state = {
            alarm: false,
            DB: '',
            visible: false,
        }
    }

    static navigationOptions = {
        title:"Add Event"
    };
    
    async componentDidMount(){
        AsyncStorage.getItem('events').then(value => {this.setState({'DB': value})});
        this._navListener = this.props.navigation.addListener('didFocus', () => {
            AsyncStorage.getItem('events').then(value => {this.setState({'DB': value})});
        });
    }

    async submit(values){
        if(this.state.DB === null){
            var empty = [];
            this.setState({'DB': JSON.stringify(empty)});
        }
        
        var parsed = JSON.parse((this.state.DB));
        var length = parsed.length;
        if(length > 0){
            values.id = parsed[length-1].id + 1;
        }
        values.alarm = this.state.alarm;

        const selectedCalendarID = await AsyncStorage.getItem('selectedCalendarID');

        if(this.state.alarm){
            await RNCalendarEvents.saveEvent(values.name, {
                calendarId: selectedCalendarID,
                startDate: (new Date(values.startDate)).toISOString(),
                endDate: (new Date(values.endDate)).toISOString(),
                alarms: [{
                    date: Number(values.alarmOffset) * 60
                }]
            }).then(id => {values.calendarEventID = id;});
        }else{
            await RNCalendarEvents.saveEvent(values.name, {
                calendarId: selectedCalendarID,
                startDate: (new Date(values.startDate)).toISOString(),
                endDate: (new Date(values.endDate)).toISOString(),
                alarms: []
            }).then(id => {values.calendarEventID = id;});
        }
        parsed.push(values);
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
            <View style={{flex:1,backgroundColor: background}}>
                <Formik
                    initialValues = { {
                        name: '',
                        startDate: '',
                        endDate: '',
                        id: 0,
                        calendarEventID: '',
                        alarmOffset: '1',
                        alarm:this.state.alarm,
                    }}

                    onSubmit = {values => {
                        this.submit(values);
                        Keyboard.dismiss();
                        this.props.navigation.navigate('EventList');
                    }}
                >
                    {({handleChange, handleSubmit, values}) => (
                        <View style={{flex:1,backgroundColor: background}}>
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
                                format= 'LLL'
                                minDate="2019-01-01"
                                maxDate="2030-12-31"
                                customStyles={{
                                dateInput: {
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
    }, preference: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        paddingTop: 15,
        paddingHorizontal: 16,
      },
});

export default withTheme(AddEvent);