package com.yucheng.LloydsBanking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yucheng.LloydsBanking.Model.Request;
import com.yucheng.LloydsBanking.Model.Response;
import com.yucheng.LloydsBanking.Service.FormatService;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormatController {

	@Autowired
	private FormatService formatService;

	@PostMapping
	public ResponseEntity<Response> getFormat(@RequestBody Request request) {
		Response res = formatService.getformat(request.getTime());
		return ResponseEntity.ok(res);
	}

}
