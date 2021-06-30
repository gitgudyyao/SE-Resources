import React, { Component } from 'react';
import { createStackNavigator, createAppContainer} from 'react-navigation';

import EventList from './eventList'
import AddEvent from './addEvent'
import Event from './event'
import { Appbar } from 'react-native-paper';
  
const Home =  createStackNavigator({
    EventList: { 
        screen: EventList,
        navigationOptions:({navigation}) => ({
            header:(
                <Appbar.Header>
                    <Appbar.Action icon="menu" onPress = {()=>navigation.openDrawer()}/>
                    <Appbar.Content title="Event List" />
                </Appbar.Header>
            ),
        })
    },
    AddEvent: { 
        screen: AddEvent,
        navigationOptions:({navigation}) => ({
            header:(
                <Appbar.Header>
                    <Appbar.BackAction onPress = {()=>navigation.goBack()}/>
                    <Appbar.Content title="Add Event" />
                </Appbar.Header>
            ),
        })
    },
    Event: {
        screen: Event,
        navigationOptions:({navigation}) => ({
            header:(
                <Appbar.Header>
                    <Appbar.BackAction onPress = {()=>navigation.goBack()}/>
                    <Appbar.Content title="Event Details" />
                </Appbar.Header>
            ),
        })
    }
},{
    initialRouteName: "EventList",
    navigationOptions:({navigation}) => ({
        header:(
            <Appbar.Header>
                <Appbar.Action icon="menu" onPress = {()=>navigation.openDrawer()}/>
                <Appbar.Content title="Evnnt List" />
            </Appbar.Header>
        ),
    }),
});

const HomeContainer = createAppContainer(Home);

export default HomeContainer;