package lt.nerimantas.ems.service;

import lt.nerimantas.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeedId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);

}
