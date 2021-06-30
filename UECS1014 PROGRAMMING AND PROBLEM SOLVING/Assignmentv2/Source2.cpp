#include <iostream>
#include <iomanip>
#include <fstream>
#include <cstring>

using namespace std;
// struct of book details
typedef struct {
	char title[50];
	char author[50];
	char publisher[50];
	char ISBN[50];
	char price[50];
	char edition[50];
	char numOfEdition[50];
	char numOfCopies[50];
	char location[50];
	char status[50];
}BOOK;
// prototype function
int getbooks(BOOK book[]);
void list(BOOK book[], int size);
void search(BOOK book[], int size);
void deleteRecord(BOOK book[], int size);
// main function
int main(void) {
	
	BOOK book[100]; // array of struct (each element contain all those variable in struct like title author snd so on)
	int size;
	int choice;

	size = getbooks(book); // return the number of books, store in variable "size"

	cout << "Welcome to the library book record system." << endl;
	do { 
		cout << "Please choose an action from the following: \n1 - list\n2 - search\n3 - delete\n4 - exit" << endl;
		cin >> choice; // selection of action
		cout << '\n';
		switch (choice){
		case 1:
			list(book, size); // call list function
			cout << '\n'; 
			break;
		case 2:
			search(book, size); // call search function
			cout << '\n';
			break;
		case 3:
			deleteRecord(book, size); // call deleteRecord function
			size = getbooks(book); // read the file again after deletion of books
			cout << '\n';
			break;
		case 4:
			cout << "Thanks for using the library book record system." << endl;
			break;
		default:
			cout << "Entered option is not valid." << endl;
		}
	} while (choice != 4); // loop until user decide to exit
	return 0;
}
// getbooks function
int getbooks(BOOK book[]) {
	
	int size = 0;
	int num = 0;
	ifstream booksListFile("booksList.txt"); // open file for read
	if (!booksListFile) { // test if file open successfully
		cout << "Error opening file.\n"; 
		exit(100);
	}
	else {
		while (booksListFile) { // loop until end of file
			booksListFile.getline(book[num].title, 50); // get information from txt file put into array of structure
			booksListFile.getline(book[num].author, 50);
			booksListFile.getline(book[num].publisher, 50);
			booksListFile.getline(book[num].edition, 50);
			booksListFile.getline(book[num].price, 50);
			booksListFile.getline(book[num].ISBN, 50);
			booksListFile.getline(book[num].numOfEdition, 50);
			booksListFile.getline(book[num].numOfCopies, 50);
			booksListFile.getline(book[num].location, 50);
			booksListFile.getline(book[num].status, 50);
			booksListFile.ignore();
			num++;  
			size++; // count the number of books to return to main function
		}
	}
	booksListFile.close(); // close file
	return size;
}
// list function
void list(BOOK book[], int size) {

	int num = 0;
	int bookNum = 0;

	cout << "Books List: \n" << endl;
	cout << "No.\tTitle\t\t\t Author\t\t  Publisher/imprint\tEdition   Price   ISBN\t\t    No.of edition  No.of copies  Location  Status\n";
	for (int num = 0; num < size; num++) { // loop through the array of struct to printout all books details
		bookNum++; // count the number of book and display on screen
		cout << bookNum << '\t' << left << setw(25) << book[num].title << setw(17) << book[num].author;
		cout << setw(22) << book[num].publisher << setw(10) << book[num].edition << setw(8) << book[num].price;
		cout << setw(24) << book[num].ISBN << setw(15) << book[num].numOfEdition << setw(8) << book[num].numOfCopies;
		cout << setw(10) << book[num].location << book[num].status << endl;
	}
	return;
}
// search function
void search(BOOK book[], int size) {

	int method;
	cout << "Please choose a method for searching books record.\nSearch by:\n1 - title\n2 - author\n3 - ISBN\n";
	cin >> method; // let user choose for method to search book

	int numOfMatch = 0;
	switch (method) {
	case 1:
		char title[50];
		cout << "Please enter the keyword of title for the book record: ";
		cin >> title;
		cout << "\nMatched books list:\n";
		cout << "No.\tTitle\t\t\t Author\t\t  Publisher/imprint\tEdition   Price   ISBN\t\t    No.of edition  No.of copies  Location  Status\n";
		for (int num = 0; num < size; num++) {
			if (strstr(book[num].title, title) != NULL) {
				numOfMatch++; // count for number of matched result
				cout << numOfMatch << '\t';  // list out all matched result
				cout << left << setw(25) << book[num].title << setw(17) << book[num].author;
				cout << setw(22) << book[num].publisher << setw(10) << book[num].edition << setw(8) << book[num].price;
				cout << setw(24) << book[num].ISBN << setw(15) << book[num].numOfEdition << setw(8) << book[num].numOfCopies;
				cout << setw(10) << book[num].location << book[num].status << endl;
			}
		}
		if (numOfMatch == 0) {
			cout << "\nDoesn't have any matched book record.\n";
		}
		break;
	case 2:
		char author[50];
		cout << "Please enter the keyword of author for the book record: ";
		cin >> author;
		cout << "\nMatched books list:\n";
		cout << "No.\tTitle\t\t\t Author\t\t  Publisher/imprint\tEdition   Price   ISBN\t\t    No.of edition  No.of copies  Location  Status\n";
		for (int num = 0; num < size; num++) {
			if (strstr(book[num].author, author) != NULL) {
				numOfMatch++; // count for number of matched result
				cout << numOfMatch << '\t';// list out all matched result
				cout << left << setw(25) << book[num].title << setw(17) << book[num].author;
				cout << setw(22) << book[num].publisher << setw(10) << book[num].edition << setw(8) << book[num].price;
				cout << setw(24) << book[num].ISBN << setw(15) << book[num].numOfEdition << setw(8) << book[num].numOfCopies;
				cout << setw(10) << book[num].location << book[num].status << endl;
			}
		}
		if (numOfMatch == 0) {
			cout << "\nDoesn't have any matched book record.\n";
		}
		break;
	case 3:
		char ISBN[50];
		cout << "Please enter the keyword of ISBN for the book record: ";
		cin >> ISBN;
		cout << "\nMatched books list:\n";
		cout << "No.\tTitle\t\t\t Author\t\t  Publisher/imprint\tEdition   Price   ISBN\t\t    No.of edition  No.of copies  Location  Status\n";
		for (int num = 0; num < size; num++) {
			if (strstr(book[num].ISBN, ISBN) != NULL) {
				numOfMatch++; // count for number of matched result
				cout << numOfMatch << '\t';// list out all matched result
				cout << left << setw(25) << book[num].title << setw(17) << book[num].author;
				cout << setw(22) << book[num].publisher << setw(10) << book[num].edition << setw(8) << book[num].price;
				cout << setw(24) << book[num].ISBN << setw(15) << book[num].numOfEdition << setw(8) << book[num].numOfCopies;
				cout << setw(10) << book[num].location << book[num].status << endl;
			}
		}
		if (numOfMatch == 0) {
			cout << "\nDoesn't have any matched book record.\n";
		}
		break;
	default:
		cout << "Please enter only number 1, 2 and 3 for your choice." << endl;
	}
	return;
}
// delete record function
void deleteRecord(BOOK book[], int size) {
	
	list(book, size); // list out available record for delete
	int bookNumForDel;
	int bookNum = 1;

	cout << "\nPlease enter the number of respective book record you would like to delete: ";
	cin >> bookNumForDel;

	ofstream tempFile("temp.txt");

	if (!tempFile) {
		cout << "Error opening file.\n"; // test if file open successfully
		exit(100);
	}
	else {
		if (bookNumForDel != 1) { // test for first record then write it in temp file
			tempFile << book[0].title << '\n' << book[0].author << '\n' << book[0].publisher; 
			tempFile << '\n' << book[0].edition << '\n' << book[0].price << '\n' << book[0].ISBN;
			tempFile << '\n' << book[0].numOfEdition << '\n' << book[0].numOfCopies;
			tempFile << '\n' << book[0].location << '\n' << book[0].status;
		}
		for (int num = 1; num < size; num++) {
			bookNum++;
			if (bookNumForDel != bookNum) { // test for remaining record and write it in temp file
				tempFile << "\n\n" << book[num].title << '\n' << book[num].author << '\n' << book[num].publisher;
				tempFile << '\n' << book[num].edition << '\n' << book[num].price << '\n' << book[num].ISBN;
				tempFile << '\n' << book[num].numOfEdition << '\n' << book[num].numOfCopies;
				tempFile << '\n' << book[num].location << '\n' << book[num].status;
			}
		}
	}
	tempFile.close(); // close file
	remove("booksList.txt"); // delete original file 
	rename("temp.txt", "booksList.txt"); // rename temp file to original file
	cout << "The recpective book record has been deleted successfully.\n";
	return;
}