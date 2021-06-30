import React, { Component } from 'react'
import {View, Text, StyleSheet , TouchableOpacity} from 'react-native'
import Icon from 'react-native-vector-icons/FontAwesome5'
import AsyncStorage from '@react-native-community/async-storage'
import {Card,Provider as PaperProvider,withTheme,FAB,Appbar,Snackbar} from 'react-native-paper'
import {SwipeListView} from 'react-native-swipe-list-view'
import type { Theme } from 'react-native-paper'
import RNCalendarEvents from 'react-native-calendar-events'

const plus_icon = (
    <Icon name='plus' size={40} color='#000000'  style={{textAlign: "center", marginTop: 7}} />
);

const menu_icon = (
    <Icon name='bars' size={30} color='#000000'/>
);

const edit_icon = (
    <Icon name='edit' size={30} color='#000000'/>
);

const delete_icon = (
    <Icon name='trash-alt' size={30} color='#000000'/>
);
class EventList extends Component{
    constructor(props){
        super(props)
        var empty = [];
        this.state = {
            events: JSON.stringify(empty),
            visible: false,
        }
    }

    async removeEvent(eventID){
        var backup = [...JSON.parse(this.state.events)];
        RNCalendarEvents.removeEvent((backup.find(event => event.id === eventID)).calendarEventID);
        backup = backup.filter(event => event.id != eventID);
        var length = backup.length;
        for(var i = 0;i < length; i++){
            backup[i].id = i;
        }
        await AsyncStorage.setItem('events',JSON.stringify(backup));
        this.setState({events:JSON.stringify(backup)});
    }

    getData = async () => {
        if(await AsyncStorage.getItem('events') === null){
            var empty = [];
            await AsyncStorage.setItem('events',JSON.stringify(empty));
            this.setState({'events': empty});
        }else{
            await AsyncStorage.getItem('events').then(value => {this.setState({'events': value})});
        }
    }

    componentDidMount(){
        this.getData();
        this._navListener = this.props.navigation.addListener('didFocus', () => {
            this.getData();
        });
        this.props.navigation.setParams({
            visible: this.state.visible,
        });
    }

    renderEventCardSingle(event){
        var date = event.startDate.split("T");
        return (    
            <View>

            <Card theme={{ roundness: 0}} onPress={() => this.props.navigation.navigate('Event',{eventID:event.id})} elevation={4}>
                <Card.Title title={event.name} subtitle={date[0]} />
            </Card>

            </View>
        )
    }

    render(){
        const {
            theme: {
                colors: {background},
            },
        } = this.props;

        return (
            <View style={{flex: 1}}>
                <SwipeListView
                    style = {{backgroundColor: background}}
                    contentContainerStyle = {{backgroundColor: background}}
                    useFlatList
                    keyExtractor={(data, index) => index.toString()}
                    data={JSON.parse(this.state.events).reverse()}
                    renderItem={ (data, rowMap) => this.renderEventCardSingle(data.item)}
                    renderHiddenItem={ (data, rowMap) => (
                        <View style={styles.rowBack}>
                            
                            <TouchableOpacity
                            style={[styles.backRight, styles.backLeftBtn]}
                            onPress={this.removeEvent.bind(this,data.item.id)}>
                            <Text style={styles.backTextWhite}>{delete_icon}</Text>
                            </TouchableOpacity>
                            
                            <TouchableOpacity
                            style={[styles.backRight, styles.backRightBtn]}
                            onPress={() => this.props.navigation.navigate('Event',{eventID:data.item.id})}>
                            <Text style={styles.backTextWhite}>{edit_icon}</Text>
                            </TouchableOpacity>
                        </View>
                    )}
                    leftOpenValue={75}
                    rightOpenValue={-75}
                />

                    <FAB.Group
                    open={this.state.open}
                    icon={this.state.open ? 'call-to-action' : 'add'}
                    actions={[
                        { icon: 'add', onPress: () => this.props.navigation.navigate('AddEvent') },
                        { icon: 'help-outline', label: 'Help', onPress: () => this.setState(state => ({ visible: !state.visible })) },
                    ]}
                    onStateChange={({ open }) => this.setState({ open })}
                    />


                

                <Snackbar
                    visible={this.state.visible}
                    onDismiss={() => this.setState({ visible: false })}
                    duration={5000}
                >
                    Try and swipe any event!
                </Snackbar>
            </View>
        )
    }
}



const styles = StyleSheet.create({
    MainContainer: {
        flex: 1,
        justifyContent: 'center',
        backgroundColor: '#F5F5F5',
    },

    Bottom:{
        flex: 1,
        justifyContent: 'flex-end',
        alignItems: 'flex-end',
        marginBottom: 20,
        marginRight: 20,
    },

    rowBack: {
        alignItems: 'center',
        backgroundColor: '#DDD',
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'space-between',
        paddingLeft: 15,
      },
      backRight: {
        alignItems: 'center',
        bottom: 0,
        justifyContent: 'center',
        position: 'absolute',
        top: 0,
        width: 75,
      },
      backRightBtn: {
        backgroundColor: 'transparent',
        right: 0,
      },
      backLeftBtn: {
        backgroundColor: 'red',
        left: 0,
      },
      fab: {
        position: 'absolute',
        margin: 16,
        right: 0,
        bottom: 0,
    },
})

export default withTheme(EventList);