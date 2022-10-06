// error code!

package ch16;
// getter setter >> command + N 메서드 자동 생성
public class Employee {

    public static int serialNum = 1000;

    private int employeeId;
    prinvate string employeeName;
    private string department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public string getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(string employeeName) {
        this.employeeName = employeeName;
    }

    public string getDepartment() {
        return department;
    }

    public void setDepartment(string department) {
        this.department = department;
    }
}
