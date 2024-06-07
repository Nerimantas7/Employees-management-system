package lt.nerimantas.ems.service.impl;

import lombok.AllArgsConstructor;
import lt.nerimantas.ems.dto.EmployeeDto;
import lt.nerimantas.ems.entity.Employee;
import lt.nerimantas.ems.mapper.EmployeeMapper;
import lt.nerimantas.ems.repository.EmployeeRepository;
import lt.nerimantas.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

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
}
