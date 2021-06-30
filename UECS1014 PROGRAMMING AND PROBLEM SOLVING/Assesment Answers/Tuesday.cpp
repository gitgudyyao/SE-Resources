#include<iostream>
#include<iomanip>

using namespace std;

//function prototypes
void get_data(double& loan, double& annual_interest, int& num_month_payments);
double compute_total_interest(double loan, double annual_interest, double num_month_payments);
double compute_monthly_payment(double loan, double total_interest, int num_month_payments);
void display_result(double loan, double annual_interest, int num_month_payments, double total_interest, double total_payment, double monthly_payment);

int main(void)
{
	double loan, annual_interest, total_interest, monthly_payment, total_payment;
	int num_month_payments;

	//call get_data to obtain read data from the keyboard
	get_data(loan, annual_interest, num_month_payments);

	//call compute_total_interest to calculate the total interest amount
	total_interest = compute_total_interest(loan, annual_interest, num_month_payments);

	//call compute_monthly_payment to calculate monthly payment
	monthly_payment = compute_monthly_payment(loan, total_interest, num_month_payments);

	//to calculate total_payment
	total_payment = loan + total_interest;

	//call to display_result to show the results
	display_result(loan, annual_interest, num_month_payments, total_interest, total_payment, monthly_payment);

	return 0;
}

//function definitions

void get_data(double& loan, double& annual_interest, int& num_month_payments)
{
	cout << "Loan amount: $";
	cin >> loan;
	cout << "Annual interest rate (in the format of 0.03 (for 3%)) : ";
	cin >> annual_interest;
	cout << "Number of monthly payments : ";
	cin >> num_month_payments;
	cout << endl;
}

double compute_total_interest(double loan, double annual_interest, double num_month_payments)
{
	return loan * annual_interest * (num_month_payments / 12);
}

double compute_monthly_payment(double loan, double total_interest, int num_month_payments)
{
	return (loan + total_interest) / num_month_payments;
}

void display_result(double loan, double annual_interest, int num_month_payments, double total_interest, double total_payment, double monthly_payment)
{
	cout << fixed << setprecision(2);
	cout << "- - Report - -\n\n";
	cout << "Loan amount\t\t: $" << setw(9) << loan << endl;
	cout << "Annual Payment Rate\t: " << annual_interest * 100 << "%\n";
	cout << "Number of Payments\t: " << num_month_payments << endl;
	cout << "Total Interest\t\t: $" << setw(9) << total_interest << endl;
	cout << "Total Payment\t\t: $" << setw(9) << total_payment << endl;
	cout << "Monthly Payment\t\t: $" << setw(9) << monthly_payment << endl << endl;
}