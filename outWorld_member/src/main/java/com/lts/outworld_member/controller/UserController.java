package com.lts.outworld_member.controller;

import com.lts.outworld_member.dto.UserDTO;
import com.lts.outworld_member.excel.UserExcel;
import com.lts.outworld_member.service.UserService;
import com.lts.utils.Constant;
import com.lts.utils.ExcelUtils;
import com.lts.utils.PageData;
import com.lts.utils.Result;
import com.lts.validator.AssertUtils;
import com.lts.validator.ValidatorUtils;
import com.lts.validator.group.AddGroup;
import com.lts.validator.group.DefaultGroup;
import com.lts.validator.group.UpdateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 用户表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-07-05
 */
@RestController
@RequestMapping("demo/user")
@Api(tags = "用户表")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
//    @RequiresPermissions("demo:user:page")
    public Result<PageData<UserDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageData<UserDTO> page = userService.page(params);

        return new Result<PageData<UserDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
//    @RequiresPermissions("demo:user:info")
    public Result<UserDTO> get(@PathVariable("id") Long id) {
        UserDTO data = userService.get(id);

        return new Result<UserDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
//    @LogOperation("保存")
//    @RequiresPermissions("demo:user:save")
    public Result save(@RequestBody UserDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        userService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
//    @LogOperation("修改")
//    @RequiresPermissions("demo:user:update")
    public Result update(@RequestBody UserDTO dto) {
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        userService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
//    @LogOperation("删除")
//    @RequiresPermissions("demo:user:delete")
    public Result delete(@RequestBody Long[] ids) {
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        userService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
//    @LogOperation("导出")
//    @RequiresPermissions("demo:user:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<UserDTO> list = userService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, UserExcel.class);
    }

}