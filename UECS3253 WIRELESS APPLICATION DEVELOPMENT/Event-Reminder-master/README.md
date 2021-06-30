# Event-Reminder
Wireless App Development Assignment

Tested with Mi Calendar.
Alarm will not behave as it should if the user selects Google Calendar.

If the facebook login is not working and saying the hash is not matched, contact me and I will add the hash into Facebook dev.

Packages used:
1. react-native-calendar-events, handle event and save it into calendar.
2. react-native-fbsdk, handle facebook login*
3. react-native-paper, most of the component sources, including theming the application
4. react-native-swipe-list-view, to create a swipable flat list
5. react-native-datepicker, 3rd party package is being used because it is more easy to use
6. formik, used to handle form submission

*: Facebook login to get the access token and used by api to fetch facebook profile image.

Known issue:
1. In some cases(super rare), newly created event will not appear in the home screen until the page is remount. Mostly likely is caused by the I/O operation is too slow.
2. Application requires a restart after prompting for permision.
