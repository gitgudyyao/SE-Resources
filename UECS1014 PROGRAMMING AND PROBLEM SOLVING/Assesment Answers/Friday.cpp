#include<iostream>
#include<iomanip>

#define SOCSO_EMPLOYEE 14.75
#define SOCSO_EMPLOYER 51.65
#define EPF_EMPLOYEE 0.11
#define EPF_EMPLOYER 0.13

using namespace std;

double read_salary();
double calculate_epf(double gross_pay, double rate);
double calculate_total(double original_value, double addition);
void print_result(double gross_pay, double epf_employee_deduct, double epf_employer_deduct,
	double total_deduct, double total_contribute, double net_pay);

int main(void)
{

	double gross_pay, net_pay;
	double epf_employee_deduct, epf_employer_deduct;
	double total_deduct, total_contribute;

	gross_pay = read_salary();
	epf_employee_deduct = calculate_epf(gross_pay, EPF_EMPLOYEE);
	epf_employer_deduct = calculate_epf(gross_pay, EPF_EMPLOYER);

	total_deduct = calculate_total(epf_employee_deduct, SOCSO_EMPLOYEE);
	total_contribute = calculate_total(epf_employer_deduct, SOCSO_EMPLOYER);

	net_pay = gross_pay - total_deduct;

	print_result(gross_pay, epf_employee_deduct, epf_employer_deduct, total_deduct, total_contribute, net_pay);

	return 0;

}

double read_salary()
{
	double salary;
	cout << "Base Salary : RM ";
	cin >> salary;
	return salary;
}

double calculate_epf(double gross_pay, double rate)
{
	double deduct = gross_pay * rate;
	return deduct;
}

double calculate_total(double original_value, double addition) {
	return original_value + addition;
}

void print_result(double gross_pay, double epf_employee_deduct, double epf_employer_deduct, double total_deduct, double total_contribute,
	double net_pay)
{
	cout << setw(42) << "PAYROLL STATEMENT\n";

	cout << fixed << setprecision(2);
	cout << "Base Salary (Gross Pay)\t\t\t\t" << "RM" << setw(10) << gross_pay << endl;
	cout << "\n";

	cout << "Deductions:\n";
	cout << setprecision(2);
	cout << "EPF   " << "(by employee - 11%)\t\t\t" << "RM" << setw(10) << epf_employee_deduct << endl;
	cout << setprecision(2);
	cout << "SOCSO " << "(by employee)\t\t\t\t" << "RM" << setw(10) << SOCSO_EMPLOYEE << endl;
	cout << "------------------------------------------------------------\n";
	cout << setprecision(2);
	cout << "Total Deductions :\t\t\t\t" << "RM" << setw(10) << total_deduct << endl;
	cout << "\n";

	cout << setprecision(2);
	cout << "Net Pay [Gross Pay - Total Deductions]\t\t" << "RM" << setw(10) << net_pay << endl;
	cout << "\n";

	cout << "Other Contributions by Employer:\n";
	cout << setprecision(2);
	cout << "EPF   " << "(by employer - 13%)\t\t\t" << "RM" << setw(10) << epf_employer_deduct << endl;
	cout << setprecision(2);
	cout << "SOCSO " << "(by employer)\t\t\t\t" << "RM" << setw(10) << SOCSO_EMPLOYER << endl;
	cout << "------------------------------------------------------------\n";
	cout << setprecision(2);
	cout << "Total of Other Contributions :\t\t\t" << "RM" << setw(10) << total_contribute << endl;

}
