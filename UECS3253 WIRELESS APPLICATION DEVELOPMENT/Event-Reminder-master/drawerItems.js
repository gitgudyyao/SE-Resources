import * as React from 'react';
import { View, StyleSheet, Platform,Dimensions,ScrollView } from 'react-native';
import {Drawer,withTheme,Switch,TouchableRipple,Paragraph,Text,Dialog,Button,Avatar, Portal, RadioButton} from 'react-native-paper';
import type { Theme } from 'react-native-paper/types';
import { LoginButton, AccessToken, LoginManager } from 'react-native-fbsdk';
import AsyncStorage from '@react-native-community/async-storage';
import RNCalendarEvents from 'react-native-calendar-events'

const dialogHeight = Math.round(Dimensions.get('window').height) * 0.8;
const scrollHeight = Math.round(Dimensions.get('window').height) * 0.55;
const scrollwidth = Math.round(Dimensions.get('window').width) * 0.8;
var empty = [];
class DrawerItems extends React.Component<Props, State> {
  
  state = {
    visible: false,
    FBaccessToken: "",
    imagePath: "https://www.stickpng.com/assets/images/585e4bf3cb11b227491c339a.png",
    calendars: empty,
    checked: '',
    visible: false,
    apiPath: '',
  }
 
  async _fetchToken(){
    await AsyncStorage.getItem('token').then(value => {this.setState({'FBaccessToken':value})});
  }

  async hideDialog(){
    await AsyncStorage.setItem('selectedCalendarID', this.state.checked);
    this.setState({ visible: false });
  }

  async componentDidMount(){
    const selectedCalendarID = await AsyncStorage.getItem('selectedCalendarID');
    const availableCalendars = await RNCalendarEvents.findCalendars();
    this.setState({'calendars': availableCalendars});
    this.setState({'checked': selectedCalendarID});
    await this._fetchToken();
    if(this.state.FBaccessToken !== null){
      let apiPath = "https://graph.facebook.com/me/picture?access_token=" + this.state.FBaccessToken;
      fetch(apiPath).then(response => {
        this.setState({'imagePath':response.url})
      })
    }
  }

  render() {
    const { colors } = this.props.theme;
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
      <View style={[styles.drawerContent, { backgroundColor: colors.surface }]}>
        <Avatar.Image style={{marginLeft:16}} size={48} source={{uri: this.state.imagePath}} />
        <Drawer.Section title="Preferences">
            <TouchableRipple onPress={this.props.toggleTheme}>
                <View style={styles.preference}>
                    <Text>Dark Theme</Text>
                    <View pointerEvents="none">
                        <Switch value={this.props.isDarkTheme} />
                    </View>
                </View>
            </TouchableRipple>
            <TouchableRipple onPress={()=>this.setState({"visible": true})}>
                <View style={styles.preference}>
                    <Text>Change calendar</Text>
                </View>
            </TouchableRipple>
        </Drawer.Section>
        <Drawer.Section title="Facebook Login">
          <View style={{marginLeft:16}}>
          <LoginButton
          onLoginFinished={
            (error, result) => {
              if (error) {
                console.log("login has error: " + result.error);
              } else if (result.isCancelled) {
                console.log("login is cancelled.");
              } else {
                AccessToken.getCurrentAccessToken().then(
                  async (data) => {
                    this.setState({'FBaccessToken':data.accessToken});
                    await AsyncStorage.setItem('token',data.accessToken);
                    this.setState({'apiPath':"https://graph.facebook.com/me/picture?access_token=" + this.state.FBaccessToken});
                    fetch(this.state.apiPath).then(response => {
                      this.setState({'imagePath':response.url})
                    })
                  }
                )
              }
            }
          }
          onLogoutFinished={ async () => {
            
            this.setState({'imagePath':"https://www.stickpng.com/assets/images/585e4bf3cb11b227491c339a.png"})
            await AsyncStorage.setItem('token',"");
            }}/>
          </View>
        </Drawer.Section>

        <Portal>
            <Dialog
            visible={this.state.visible}
            onDismiss={()=>this.setState({"visible": false})}
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
      </View>

      
    );
  }
}

const styles = StyleSheet.create({
  drawerContent: {
    flex: 1,
    paddingTop: Platform.OS === 'android' ? 25 : 22,
  },
  preference: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingVertical: 12,
    paddingHorizontal: 16,
  },
  row: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingVertical: 8,
    paddingHorizontal: 16,
  },
});

export default withTheme(DrawerItems);
