// Remember to include _CRT_SECURE_NO_WARNINGS in the preprocessor definition //
#include <iostream>
#include <iomanip>
#include <fstream>
#include <ctype.h>
#include <cstring>
#include <climits> //for INT_MAX
using namespace std;

typedef struct {
	char name[500];
	char number[500];
	char address[500];
	char company[500];
	char arrival[500];
	char collection[500];

}RECORD;

void read_record(RECORD record[], int& number_of_record); //update record array
void display_record(RECORD record[], int number_of_record); //show record in table form
void delete_record(RECORD record[], int number_of_record); //delete record within the array
void record_menu(RECORD record[], int number_of_record); //show main menu 
void add_record(RECORD record[], int number_of_record); //addition of new records
void search_record(RECORD record[], int number_of_record); //search desired record
void modify_record(RECORD record[], int number_of_record); //modify detail of record

int main(void) {
	system("color B"); //set font color to light blue
	system("MODE CON COLS=500"); //set windows size
	RECORD record[100];
	int number_of_record;
	read_record(record, number_of_record);
	record_menu(record, number_of_record);
	return 0;
}

void read_record(RECORD record[], int& number_of_record) {
	int i = 0;
	ifstream recordlist("recordlist.txt");
	//check text file existant
	if (!recordlist) {
		cout << "Text file unavailable, please place relevant text file in the folder.\n";
		system("pause");
		exit(100);
	}
	while (recordlist) {
		recordlist.getline(record[i].name, 500);
		recordlist.getline(record[i].number, 500);
		recordlist.getline(record[i].address, 500);
		recordlist.getline(record[i].company, 500);
		recordlist.getline(record[i].arrival, 500);
		recordlist.getline(record[i].collection, 500);
		i++;
	}
	//the number_of_record is the last index number + 1
	number_of_record = i - 1; 
	recordlist.close();
}

void display_record(RECORD record[], int number_of_record) {
	//initialize length to set alignment in the list
	unsigned int name_length = 5;
	unsigned int number_length = 16;
	unsigned int address_length = 14;

	//To extend further the required space
	for (int i = 0; i < number_of_record; i++) {
		if (strlen(record[i].name)>name_length)
			name_length = strlen(record[i].name);
		if (strlen(record[i].number)>number_length)
			number_length = strlen(record[i].number);
		if (strlen(record[i].address)>address_length)
			address_length = strlen(record[i].address);
	}
	// to print out a long line of '*'
	cout << setfill('*') << setw(name_length + address_length + number_length + 78) << "*" << endl << setfill(' ')
		<< "No.  "
		<< setw(name_length) << "Name\t"
		<< " " << setw(number_length) << "Contact Number \t"
		<< " " << setw(address_length) << "Email Address\t"
		<< " " << setw(14) << "Courier Company\t"
		<< " " << setw(5) << "Arrival Date\t"
		<< " " << setw(5) << "Collection date\n";
	cout << setfill('*') << setw(name_length + address_length + number_length + 78) << "*" << endl << setfill(' ') << endl;

	for (int i = 0; i < number_of_record; i++) {
		cout << setw(2) << i + 1 << ". "
			<< setw(name_length) << record[i].name << "\t"
			<< setw(number_length) << record[i].number << "\t"
			<< setw(address_length) << record[i].address << "\t"
			<< setw(14) << record[i].company << "\t\t"
			<< setw(5) << record[i].arrival << "\t"
			<< setw(5) << record[i].collection << endl;
		//to print out a long line of '-'
		cout << setfill('-') << setw(name_length + address_length + number_length + 78) << "-" << endl << setfill(' '); 
	}
}

void delete_record(RECORD record[], int number_of_record) {
	int selection;
	display_record(record, number_of_record);
	cout << "Please select the record to delete by entering the number(0 to exit to main menu): ";
	cin >> selection;
	if (selection == 0) {
		system("cls");
		record_menu(record, number_of_record);
	}

	//verifying if input is valid
	while (cin.fail() || selection > number_of_record || selection < 1) {
		cin.clear();
		cin.ignore(INT_MAX, '\n');
		cout << "Please input valid number given only.\n";
		cout << "Please input the proper number: ";
		cin >> selection;
		if (selection ==0) {
			system("cls");
			record_menu(record, number_of_record);
		}
	}

	//moving the last record to selected record,so the selected record detail will be modified
	strcpy(record[selection - 1].name, record[number_of_record - 1].name);
	strcpy(record[selection - 1].number, record[number_of_record - 1].number);
	strcpy(record[selection - 1].address, record[number_of_record - 1].address);
	strcpy(record[selection - 1].company, record[number_of_record - 1].company);
	strcpy(record[selection - 1].arrival, record[number_of_record - 1].arrival);
	strcpy(record[selection - 1].collection, record[number_of_record - 1].collection);


	ofstream recordlist("recordlist.txt");

	//check if .txt file exist
	if (!recordlist) {
		cout << "Text file NOT FOUND. Please insert the required recordlist.txt\n";
	}

	//overwrite the text file without the last line
	for (int i = 0; i < number_of_record - 1; i++) {
		recordlist << record[i].name << endl
			<< record[i].number << endl
			<< record[i].address << endl
			<< record[i].company << endl
			<< record[i].arrival << endl
			<< record[i].collection << endl;
	}
}

void record_menu(RECORD record[], int number_of_record) {
	int selection;

	//displays the main menu
	cout << "******************************" << endl;
	cout << "WELCOME TO THE ACCOUNT RECORD!\n";
	cout << "******************************" << endl;
	cout << "1) Display Record List.\n";
	cout << "2) Delete Record.\n";
	cout << "3) Add Record.\n";
	cout << "4) Search Record.\n";
	cout << "5) Modify Record Information.\n";
	cout << "6) Exit.\n";
	cout << "******************************" << endl;
	cout << "Please select function (1 - 6): ";
	cin >> selection;

	//verifying input
	while (cin.fail() || selection < 1 || selection>6) {
		cin.clear();
		cin.ignore(INT_MAX, '\n');
		cout << "Please input valid number only.\n";
		cout << "Please input the number again: ";
		cin >> selection;
	}

	//selection of function based on input
	if (selection == 1) {
		display_record(record, number_of_record);
		system("pause");
		system("cls");
		record_menu(record, number_of_record);
	}
	else if (selection == 2) {
		delete_record(record, number_of_record);
		read_record(record, number_of_record);
		system("pause");
		system("cls");
		record_menu(record, number_of_record);
	}
	else if (selection == 3) {
		add_record(record, number_of_record);
		read_record(record, number_of_record);
		system("pause");
		system("cls");
		record_menu(record, number_of_record);
	}
	else if (selection == 4) {
		search_record(record, number_of_record);
		system("pause");
		system("cls");
		record_menu(record, number_of_record);
	}
	else if (selection == 5) {
		modify_record(record, number_of_record);
	}
	else if (selection == 6) {
		exit(100); //exits the program
	}

}

void add_record(RECORD record[], int number_of_record) {
	char input[500];
	cout << "Leave a space if it is empty(0 to exit to menu).\n";

	//modify Record Name or cancel
	cout << "Please enter the Name: ";
	cin.ignore();
	cin.getline(input, 500);
	if (!strcmp(input, "0")) {
		system("cls");
		record_menu(record, number_of_record);
	}
	strcpy(record[number_of_record].name, input);

	//modify Contact Number or cancel
	cout << "Please enter the Contact Number: ";
	cin.getline(input, 500);
	if (!strcmp(input, "0")) {
		system("cls");
		record_menu(record, number_of_record);
	}
	strcpy(record[number_of_record].number, input);

	//modify Email Address or cancel
	cout << "Please enter the Email Address: ";
	cin.getline(input, 500);
	if (!strcmp(input, "0")) {
		system("cls");
		record_menu(record, number_of_record);
	}
	strcpy(record[number_of_record].address, input);

	//modify Courier Company or cancel
	cout << "Please enter the Courier Company: ";
	cin.getline(input, 500);
	if (!strcmp(input, "0")) {
		system("cls");
		record_menu(record, number_of_record);
	}
	strcpy(record[number_of_record].company, input);

	//modify Arrival Date or cancel
	cout << "Please enter the Arrival Date: ";
	cin.getline(input, 500);
	if (!strcmp(input, "0")) {
		system("cls");
		record_menu(record, number_of_record);
	}
	strcpy(record[number_of_record].arrival, input);

	//modify Collection Date or cancel
	cout << "Please enter the Collection Date: ";
	cin.getline(input, 500);
	if (!strcmp(input, "0")) {
		system("cls");
		record_menu(record, number_of_record);
	}
	strcpy(record[number_of_record].collection, input);

	ofstream recordlist("recordlist.txt");

	//overwrite text file with new record
	for (int i = 0; i <= number_of_record; i++) {
		recordlist << record[i].name << endl
			<< record[i].number << endl
			<< record[i].address << endl
			<< record[i].company << endl
			<< record[i].arrival << endl
			<< record[i].collection << endl;
			
	}
	recordlist.close();

}

void search_record(RECORD record[], int number_of_record) {
	char search[100];
	int recordnum = 1, time = 0;

	//intialize the lenname_length to avoid miss alignment if one of the section is empty 
	unsigned int name_length = 20;
	unsigned int number_length = 12;
	unsigned int address_length = 11;

	//check the longest length of space
	for (int i = 0; i < number_of_record; i++) {
		if (strlen(record[i].name)>name_length)
			name_length = strlen(record[i].name);
		if (strlen(record[i].number)>number_length)
			number_length = strlen(record[i].number);
		if (strlen(record[i].address)>address_length)
			address_length = strlen(record[i].address);
	}

	cout << "This search function only include Name, Contact Number & Email Address (WARNING : CASE SENSITIVE!).\n";
	cout << "Please enter the keyword: ";
	cin.ignore();
	cin.getline(search, 100);
	for (int i = 0; i < number_of_record; i++) {
		//looking for keyword in Name, Contact Number & Email Address
		char *recordname = strstr(record[i].name, search);
		char *numbername = strstr(record[i].number, search);
		char *addressname = strstr(record[i].address, search);
		if (recordname || numbername || addressname) {
			if (time != 1) {
				//to print out the header for the first time
				time = 1;
				cout << "     "
					<< setw(name_length) << "Name\t"
					<< " " << setw(number_length) << "Contact Number\t"
					<< " " << setw(20) << "Email Address\n";
				cout << setw(2) << recordnum << ". "
					<< setw(name_length) << record[i].name << "\t"
					<< setw(number_length) << record[i].number << "\t"
					<< setw(20) << record[i].address << endl;
				recordnum++;
			}
			else {
				cout << setw(2) << recordnum << ". "
					<< setw(name_length) << record[i].name << "\t"
					<< setw(number_length) << record[i].number << "\t"
					<< setw(20) << record[i].address << endl;
				recordnum++;
			}
			cout << setfill('-') << setw(name_length + address_length + 20 + 10) << "-" << endl << setfill(' ');//prints out a long line
		}
	}
	if (recordnum < 2) {
		//if no record found 
		cout << "Nothing found.\n";
	}
}

void modify_record(RECORD record[], int number_of_record) {
	int record_selection, info_selection;
	display_record(record, number_of_record);
	cout << "Please select a number to modify the record (0 to exit to menu). ";
	cin >> record_selection;
	//check if user wants to cancel
	if (record_selection == 0) {
		system("cls");
		record_menu(record, number_of_record);
	}

	//verify input
	while (cin.fail() || record_selection > number_of_record || record_selection < 1) {
		cin.clear();
		cin.ignore(INT_MAX, '\n');
		cout << "Please insert valid number only.\n";
		cout << "Please re-insert the number: ";
		cin >> record_selection;

		//check if user wants to cancel
		if (record_selection == 0) {
			system("cls");
			record_menu(record, number_of_record);
		}
	}

	//print out appropriate main menu
	cout << "Please select a number to modify the specific info.\n";
	cout << "1. Record Name\n"
		 << "2. Contact Number\n"
		 << "3. Email Address\n"
		 << "4. Courier Company\n"
		 << "5. Arrival Date\n"
		 << "6. Collection Date\n"
		 << "7. Exit to Record Selection\n"
		 << "0. Exit to menu\n";
	cin >> info_selection;
	if (info_selection == 0) {
		//if user wants to exit to the main menu
		system("cls");
		record_menu(record, number_of_record);
	}
	else if (info_selection == 7) {
		//if user want to reselect the record
		system("cls");
		modify_record(record, number_of_record);
	}

	//verify input
	while (cin.fail() || info_selection < 1 || info_selection>5) {
		cin.clear();
		cin.ignore(INT_MAX, '\n');
		cout << "Please insert valid number only.\n";
		cout << "Please re-insert the number: ";
		cin >> info_selection;
		if (info_selection == 0) {
			system("cls");
			record_menu(record, number_of_record);
		}
		else if (info_selection == 7) {
			system("cls");
			modify_record(record, number_of_record);
		}
	}

	cin.ignore();

	//acquire updated info from input
	if (info_selection == 1) {
		cout << "Please insert the New Name.\n";
		cin.getline(record[record_selection - 1].name, 500);
	}
	else if (info_selection == 2) {
		cout << "Please insert the New Contact Number.\n";
		cin.getline(record[record_selection - 1].number, 500);
	}
	else if (info_selection == 3) {
		cout << "Please insert the New Email Address.\n";
		cin.getline(record[record_selection - 1].address, 500);
	}
	else if (info_selection == 4) {
		cout << "Please insert the New Courier Company.\n";
		cin.getline(record[record_selection - 1].company, 500);
	}
	else if (info_selection == 5) {
		cout << "Please insert the New Arrival Date.\n";
		cin.getline(record[record_selection - 1].arrival, 500);
	}
	else if (info_selection == 6) {
		cout << "Please insert the New Collection Date.\n";
		cin.getline(record[record_selection - 1].collection, 500);
	}
	

	ofstream recordlist("recordlist.txt");
	//overwrite the new input into the .txt
	for (int i = 0; i < number_of_record; i++) {
		recordlist << record[i].name << endl
			<< record[i].number << endl
			<< record[i].address << endl
		    << record[i].company << endl
			<< record[i].arrival << endl
			<< record[i].collection << endl;
		
	}
	recordlist.close();
	system("pause");
	system("cls");
	record_menu(record, number_of_record);
}