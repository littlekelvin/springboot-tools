package com.example.springboot.controller;

import com.example.springboot.service.Message;
import com.example.springboot.service.MessageService;
import com.example.springboot.vo.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */

@Api(value = "message", description = "message operatin API", protocols = "http")
@RestController
public class RestApiController {
    @Autowired
    MessageService messageService;

    @GetMapping("messages")
    @ApiOperation(value = "all message list", notes = "complete message list", response = List.class,
            produces = "application/json")
    public List<Message> list() {
        return messageService.findAll();
    }

    @PostMapping("message")
    @ApiOperation(value = "add message", notes = "Add new message", response = Message.class,
            produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "message id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "message title", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "content", value = "message content", required = false, dataType = "String", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "request success"),
            @ApiResponse(code = 302, message = "request redirect"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "request forbidden"),
            @ApiResponse(code = 404, message = "resource not found")
    })
    public Message save(@RequestBody Message message) {
        System.out.println(message);
        return messageService.save(message);
    }

    @PutMapping("message")
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }

    @GetMapping("message/{id}")
    public ResponseResult<Message> findById(@PathVariable Long id) {
        ResponseResult<Message> result = new ResponseResult<>();
        result.setCode(0);
        result.setMessage("request success");
        result.setData(messageService.findById(id));
        return result;
    }

    @DeleteMapping("message/{id}")
    public void deleteById(@PathVariable Long id) {
        messageService.deleteById(id);
    }

}
