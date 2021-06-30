#include <iostream>
#include <iomanip>

using namespace std;

// definining the prices for the 5 products as constants
#define Product1_Price 2.98
#define Product2_Price 4.50
#define Product3_Price 9.98
#define Product4_Price 4.49
#define Product5_Price 7.86

// function prototypes for the 5 functions used
void readData(int& quantity1, int& quantity2, int& quantity3,
	int& quantity4, int& quantity5);

double calculateSubTotal(int quantity1, int quantity2, int quantity3,
	int quantity4, int quantity5);

double calculateTax(double subTotal, double taxRate);

double calculateTotal(double subTotal, double tax);

void printResult(int quantity1, int quantity2, int quantity3,
	int quantity4, int quantity5, 	double subTotal, double tax, 
	double totalPrice);


int main(void)
{
	// tax rate is a constant
	const double taxRate = 0.06;
	int product1_quantity, product2_quantity, product3_quantity,
		product4_quantity, product5_quantity;
	double subTotal, tax, totalPrice;

	// calling readData to obtain the quantities of the 5 products from the keyboard
	readData(product1_quantity, product2_quantity, product3_quantity,
		product4_quantity, product5_quantity);
	// calling calculateSubTotal to calculate the subtotal
	subTotal = calculateSubTotal(product1_quantity, product2_quantity, product3_quantity,
		product4_quantity, product5_quantity);

	// calling calculateTax to calculate the tax
	tax = calculateTax(subTotal, taxRate);

	// calling calculateTotal to calculate the total
	totalPrice = calculateTotal(subTotal, tax);

	// calling printResult to print the result 
	printResult(product1_quantity, product2_quantity, product3_quantity, 
		product4_quantity, product5_quantity, subTotal, tax, totalPrice);

	return 0;
}


void readData(int& quantity1, int& quantity2, int& quantity3, 
	int& quantity4, int& quantity5) {

	cout << "Quantity of Product 1 ($ " << fixed << setprecision(2) << Product1_Price << ") : ";
	cin >> quantity1;
	cout << "Quantity of Product 2 ($ " << Product2_Price << ") : ";
	cin >> quantity2;
	cout << "Quantity of Product 3 ($ " << Product3_Price << ") : ";
	cin >> quantity3;
	cout << "Quantity of Product 4 ($ " << Product4_Price << ") : ";
	cin >> quantity4;
	cout << "Quantity of Product 5 ($ " << Product5_Price << ") : ";
	cin >> quantity5;
}

double calculateSubTotal(int quantity1, int quantity2, int quantity3,
	int quantity4, int quantity5) {

	double subtotal = (quantity1 * Product1_Price) +
		(quantity2 * Product2_Price) + (quantity3 * Product3_Price) +
		(quantity4 * Product4_Price) + (quantity5 * Product5_Price);

	return subtotal;
}

double calculateTax(double subTotal, double taxRate) {
	return subTotal * taxRate;
}

double calculateTotal(double subTotal, double tax) {
	return subTotal + tax;
}

void printResult(int product1_quantity, int product2_quantity, int
	product3_quantity, int 	product4_quantity, int product5_quantity,
	double subTotal, double tax, double totalPrice)
{
	cout << endl <<  "\t\t\tCHARGES" << endl;
	cout << endl << endl;
    
    // Displaying charges with appropriate formatting
	cout << "DESCRIPTION" << setw(10) << "COST $" << setw(14) << "QUANTITY" << setw(14) << "CHARGE $" << endl;
	cout << "-----------" << setw(10) << "------" << setw(14) << "--------" << setw(14) << "--------" << endl;
	cout << "Product 1 " << fixed << setprecision(2) << setw(10) << Product1_Price << setw(10) << product1_quantity << setw(18) << product1_quantity * Product1_Price << endl;
	cout << "Product 2 " << fixed << setprecision(2) << setw(10) << Product2_Price << setw(10) << product2_quantity << setw(18) << product2_quantity * Product2_Price << endl;
	cout << "Product 3 " << fixed << setprecision(2) << setw(10) << Product3_Price << setw(10) << product3_quantity << setw(18) << product3_quantity * Product3_Price << endl;
	cout << "Product 4 " << fixed << setprecision(2) << setw(10) << Product4_Price << setw(10) << product4_quantity << setw(18) << product4_quantity * Product4_Price << endl;
	cout << "Product 5 " << fixed << setprecision(2) << setw(10) << Product5_Price << setw(10) << product5_quantity << setw(18) << product5_quantity * Product5_Price << endl;
	cout << endl;
	cout << endl;
	cout << "SUBTOTAL" << fixed << setprecision(2) << setw(40) << right << subTotal << endl;
	cout << "TAX (6%)" << fixed << setprecision(2) << setw(40) << right << tax << endl;
	cout << endl;
	cout << endl;
	cout << "TOTAL   " << fixed << setprecision(2) << setw(40) << right << totalPrice << endl;

}
