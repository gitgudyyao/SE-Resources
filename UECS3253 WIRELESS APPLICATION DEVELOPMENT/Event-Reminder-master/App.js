import HomeContainer from './src/navigators';
import React, {Component } from 'react'
import { StatusBar, Platform ,Alert,PermissionsAndroid, View,StyleSheet,ScrollView, Dimensions} from 'react-native';
import {Provider as PaperProvider, DarkTheme, DefaultTheme, Portal, Dialog, Button, RadioButton, Paragraph, TouchableRipple} from 'react-native-paper'
import type { Theme } from 'react-native-paper';
import createReactContext from 'create-react-context';
import { createDrawerNavigator, createAppContainer } from 'react-navigation';
import DrawerItems from './drawerItems'
import AsyncStorage from '@react-native-community/async-storage'
import RNCalendarEvents from 'react-native-calendar-events'

const dialogHeight = Math.round(Dimensions.get('window').height) * 0.8;
const scrollHeight = Math.round(Dimensions.get('window').height) * 0.55;
const scrollwidth = Math.round(Dimensions.get('window').width) * 0.8;

type State = {
  theme: Theme,
};

const PrefContext: any = createReactContext();

const Base = createDrawerNavigator(
  { Home: {
    screen: HomeContainer
  }},{
    contentComponent: () => (
      <PrefContext.Consumer>
        { preferences => (
            <DrawerItems
              toggleTheme = {preferences.theme}
              isDarkTheme = {preferences.isDarkTheme}
            />
        )}
      </PrefContext.Consumer>
    )
  }
)

const BaseContainer = createAppContainer(Base);

export default class App extends Component {
  constructor(props){
    super(props);
    var empty = [];
    this.state ={
      'theme' : DefaultTheme,
      'calendars': empty,
      'checked': '',
      'visible': false,
    }
  }

  async hideDialog(){
    await AsyncStorage.setItem('selectedCalendarID', this.state.checked);
    this.setState({ visible: false });
  }

  async componentDidMount(){
    let result = await this.requestPermission();
    StatusBar.setBarStyle('light-content');
    const selectedCalendarID = await AsyncStorage.getItem('selectedCalendarID');
    if(selectedCalendarID === null){
      const availableCalendars = await RNCalendarEvents.findCalendars();
      this.setState({'calendars': availableCalendars});
      this.setState({'visible': true});
    }
    try{
      const pref = await AsyncStorage.getItem('preferences');
      const preferences = JSON.parse(pref);
      if(preferences){
        this.setState(state => ({
          theme: preferences.theme === 'dark' ? DarkTheme : DefaultTheme,
        }));
      }
    }catch (e){
      //IGNORE
    }
  }

  async requestPermission() {
    try {
      const granted = await PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.WRITE_CALENDAR,
        {
          title: 'Event Reminder Calendar Permission',
          message:
            'Event Reminder requires calendar permission to write event to your primary calendar.',
          buttonPositive: 'OK',
        },
      );
      if (granted === PermissionsAndroid.RESULTS.GRANTED) {
        console.log('You can use the calendar');
      } else {
        Alert.alert('Warning','Event Reminder will not work properly until calendar permission is given.');
      }
    } catch (err) {
      console.warn(err);
    }

    try {
      const granted = await PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.READ_CALENDAR,
        {
          title: 'Event Reminder Calendar Permission',
          message:
            'Event Reminder requires calendar permission to read event that is written with this app.',
          buttonPositive: 'OK',
        },
      );
      if (granted === PermissionsAndroid.RESULTS.GRANTED) {
        console.log('You can use the calendar');
      } else {
        Alert.alert('Warning','Event Reminder will not work properly until calendar permission is given.');
      }
    } catch (err) {
      console.warn(err);
    }

    return 1;
  }

  savePref = async()=>{
    try {
      await AsyncStorage.setItem('preferences', JSON.stringify({
        'theme':this.state.theme === DarkTheme ? 'dark':'light',
      }));
    }catch (e){
      //IGNORE
    }
  }

  toggleTheme = () => 
    this.setState(
      state=> ({
        theme: state.theme === DarkTheme ? DefaultTheme: DarkTheme,
      }),
      this.savePref
    );

  render() {
    const calendarList = this.state.calendars.map( calendar => {
    return(
        <View key={calendar.id}>
        <TouchableRipple onPress={()=>this.setState({'checked': calendar.id})}>
        <View style={styles.row}>
        <View>
            <Paragraph>{calendar.title}</Paragraph>
            <Paragraph>Type: {calendar.type}</Paragraph>
        </View>
            <View pointerEvents="none">
            <RadioButton
            
            value={calendar.id}
            status={this.state.checked === calendar.id ? 'checked' : 'unchecked'}
            />
            </View>
        </View>
        </TouchableRipple>
        </View>
    )
    })
    
    return (
      <PaperProvider theme = {this.state.theme}>
        <PrefContext.Provider
          value={{
            theme: this.toggleTheme,
            isDarkTheme: this.state.theme === DarkTheme,
          }}
        >
          <BaseContainer/>
        </PrefContext.Provider>
        <Portal>
            <Dialog
            dismissable={false}
            visible={this.state.visible}
            style={{height: dialogHeight}}>
                <Dialog.Title>Select your calendar</Dialog.Title>
                <Dialog.Content>
                <Paragraph>We recommend you to choose any other than Google Calendar</Paragraph>
                <RadioButton.Group>
                <Dialog.ScrollArea style={{height:scrollHeight}}>
                <ScrollView>
                {calendarList}
                </ScrollView>
                </Dialog.ScrollArea>
                </RadioButton.Group>
                </Dialog.Content>
                <Dialog.Actions style={{paddingVertical:0}}>
                <Button disabled={this.state.checked == '' ? true : false} onPress={this.hideDialog.bind(this)}>Done</Button>
                </Dialog.Actions>
            </Dialog>
        </Portal> 
      </PaperProvider>
    );
  }
}

const styles = StyleSheet.create({
  row: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingVertical: 8,
    paddingHorizontal: 16,
  },
})