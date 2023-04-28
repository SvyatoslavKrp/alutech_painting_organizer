package org.painting.alutechorganizer.web;

import lombok.RequiredArgsConstructor;
import org.painting.alutechorganizer.dto.WorkerDto;
import org.painting.alutechorganizer.service.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor

@Controller
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService service;

    @PostMapping("/create_worker")
    public void saveWorker(@Valid WorkerDto worker) {
        service.saveWorker(worker);
    }

    @GetMapping("/create_worker")
    public String getSaveForm() {
        return "create_worker";
    }

    @GetMapping(value = "/personal_page",
                params = "id")
    public ModelAndView getWorker(@RequestParam Integer id) {

        WorkerDto worker = service.getWorkerById(id);
        return new ModelAndView("personal_page", "worker", worker);

    }

    @GetMapping(value = "/personal_page")
    public ModelAndView getWorker(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String surname) {

        WorkerDto worker = service.getWorkerByNameOrSurname(name, surname);
        return new ModelAndView("personal_page", "worker", worker);

    }

    @DeleteMapping("/personal_page")
    public void deleteWorkerById(@RequestParam Integer id) {
        service.deleteWorkerById(id);
    }

    @GetMapping("/all_workers")
    public ModelAndView getAllWorkers() {

        List<WorkerDto> allWorkers = service.getAllWorkers();
        return new ModelAndView("all_workers", "allWorkers", allWorkers);

    }

    @PutMapping("/personal_page")
    public void updateWorkerById(WorkerDto worker, Integer id) {
        service.updateWorker(worker, id);
    }

}
