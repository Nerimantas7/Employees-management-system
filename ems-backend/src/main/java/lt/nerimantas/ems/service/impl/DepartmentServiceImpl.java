package lt.nerimantas.ems.service.impl;

import lombok.AllArgsConstructor;
import lt.nerimantas.ems.dto.DepartmentDto;
import lt.nerimantas.ems.entity.Department;
import lt.nerimantas.ems.mapper.DepartmentMapper;
import lt.nerimantas.ems.repository.DepartmentRepository;
import lt.nerimantas.ems.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
