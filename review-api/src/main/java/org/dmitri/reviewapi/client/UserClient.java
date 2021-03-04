package org.dmitri.reviewapi.client;

import org.dmitri.reviewapi.model.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@FeignClient(name = "user-api")
public interface UserClient {

    @GetMapping("/{id}")
    UserDto findById(@PathVariable Long id);
}
