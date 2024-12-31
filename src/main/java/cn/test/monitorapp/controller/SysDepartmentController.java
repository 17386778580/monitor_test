package cn.test.monitorapp.controller;

import cn.test.monitorapp.entity.SysDepartment;
import cn.test.monitorapp.service.ISysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.test.monitorapp.entity.R;


@RestController
@RequestMapping("/sysDepartment")
public class SysDepartmentController {
    @Autowired
    private ISysDepartmentService sysDepartmentService;
    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<SysDepartment> getById(@PathVariable(name = "id") Integer id) {
        SysDepartment dept = sysDepartmentService.getById(id);
        return R.ok(dept);
    }
    /**
     * 新增部门
     *
     * @param dept
     * @return
     */
    @PostMapping("/save")
    public R<SysDepartment> save(@RequestBody SysDepartment dept) {
        boolean result = sysDepartmentService.save(dept);
        if (result) {
            return R.ok(dept);
        } else {
            return R.failed();
        }
    }
    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R<SysDepartment> delete(@PathVariable(name = "id") Integer id) {
        SysDepartment dept = sysDepartmentService.getById(id);
        boolean result = sysDepartmentService.removeById(id);
        if (result) {
            return R.ok(dept);
        } else {
            return R.failed();
        }
    }
    /**
     * 更新部门
     *
     * @param dept
     * @return
     */
    @PutMapping("/update")
    public R<SysDepartment> update(@RequestBody SysDepartment dept) {
        boolean result = sysDepartmentService.updateById(dept);
        if (result) {
            return R.ok(dept);
        } else {
            return R.failed();
        }
    }
}