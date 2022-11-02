package com.realnet.gitclone.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.realnet.gitclone.exception.ResourceNotFoundException;
import com.realnet.gitclone.model.ScriptRunnerModel;
import com.realnet.gitclone.service.ScriptRunnerService;


@RestController
@CrossOrigin(origins = "http://localhost:4123")
@RequestMapping("/api")
public class ScriptRunnerController {
	
//	@Autowired
//	ScriptRunnerService scriptRunnerService;
	
	@Value("${project_path}")
	private String projectpath;
	
//	@Value("${project_pathcheck}")
//	private String projectpathcheck;


	/**
//	 * Get All users.
//	 */
//	@RequestMapping(value = "/getAllScripts", method = RequestMethod.GET, headers = { "Accept=application/json" })
//	@ResponseStatus(HttpStatus.OK)
//	public List<ScriptRunnerModel> getAllScripts() {
//		return scriptRunnerService.getAll();
//	}
//
//	/**
//	 * Gets users by id.
//	 */
//	@GetMapping("/getScriptById/{id}")
//	public ResponseEntity<ScriptRunnerModel> getScriptById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
//		return scriptRunnerService.getById(id);
//	}
//
//	/**
//	 * create new user
//	 */
//	@PostMapping("/addScript")
//	ScriptRunnerModel addScript(@Valid @RequestBody ScriptRunnerModel scriptRunnerModel) {
//		return scriptRunnerService.create(scriptRunnerModel);
//	}
//
//	/**
//	 * update user
//	 */
//	@PutMapping("/updateScriptById/{id}")
//	public ResponseEntity<ScriptRunnerModel> updateScriptById(@PathVariable(value = "id") int id,
//			@Valid @RequestBody ScriptRunnerModel scriptRunnerModel) throws ResourceNotFoundException {
//
//		return scriptRunnerService.update(id, scriptRunnerModel);
//	}
//
//	/**
//	 * delete user
//	 */
//	@DeleteMapping("/deleteScriptById/{id}")
//	public Map<String, Boolean> deleteScriptById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
//		return scriptRunnerService.delete(id);
//	}
	
	
	/**
	 * runScript method by reading file
	 *
	 */
	@GetMapping(value = "/runScript")
	public  void runScript()  {
		
		System.out.println("runScript method called in ScriptRunnerController");
		
		String str = null;
		
		ProcessBuilder pb = new 
//		ProcessBuilder("C://Users//Karam//git//surepipe-runner//src//main//resources//ScriptFiles//multi_output.bat");
		ProcessBuilder(projectpath +"//src//main//resources//ScriptFiles//multi_output.bat");
//		ProcessBuilder(projectpath+"//" +path);
		

		System.out.println(projectpath);
//		System.out.println(projectpathcheck+path);
		
		pb.directory(new File(System.getProperty("user.home")));

		try {

			Process process = pb.start();
//			Process process = Runtime.getRuntime().exec("where java");

			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

			

			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();

			} catch (IOException e) {
	
				e.printStackTrace();
			}
	
		
	}

}
