package lt.nerimantas.ems.service.impl;

import lombok.AllArgsConstructor;
import lt.nerimantas.ems.dto.EmployeeDto;
import lt.nerimantas.ems.entity.Employee;
import lt.nerimantas.ems.exception.ResourceNotFoundException;
import lt.nerimantas.ems.mapper.EmployeeMapper;
import lt.nerimantas.ems.repository.EmployeeRepository;
import lt.nerimantas.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }
}
