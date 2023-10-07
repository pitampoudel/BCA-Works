#include <stdio.h>
#include <string.h>
  
// Declaration of the dependent structure(Inner structure)
struct Employee
{
  int employee_id;
  char name[20];
  int salary;
};
  
// Declaration of the Outer structure
struct Organization  
{
  char organization_name[20];
  char org_street[20];
    
  // Dependent structure is used as a member inside the main structure for implementing nested structure
  struct Employee emp; 
};
  

int main()
{
  // Structure variable
  struct Organization org; 
    
 
    
  org.emp.employee_id = 101;  
  strcpy(org.emp.name, "Nishan");
  org.emp.salary = 2;
  strcpy(org.organization_name, "Neoteric");
  strcpy(org.org_street, "Bhanimandal");
    
    
  // Printing the details
  printf("Organization Name : %s\n", org.organization_name);  
  printf("Organization Street : %s\n", org.org_street);  
  printf("Employee id : %d\n", org.emp.employee_id);  
  printf("Employee name : %s\n", org.emp.name);  
  printf("Employee Salary : %d\n", org.emp.salary);  
}
