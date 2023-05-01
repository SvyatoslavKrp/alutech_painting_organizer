package org.painting.alutechorganizer.web;

import lombok.RequiredArgsConstructor;
import org.painting.alutechorganizer.dto.WorkplaceDto;
import org.painting.alutechorganizer.service.WorkplaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/workplaces")
public class WorkplaceController {

    private final WorkplaceService service;

    @PostMapping("/create_workplace")
    public void createWorkplace(@Valid WorkplaceDto workplace) {
        service.saveWorkplace(workplace);
    }

    @GetMapping("/get_all_workplaces")
    public ModelAndView getAllWorkplaces() {
        List<WorkplaceDto> allWorkplaces = service.getAllWorkplaces();
        return new ModelAndView("all_Workplaces", "allWorkplaces", allWorkplaces);
    }

    @GetMapping(value = "/workplace_page")
    public void getWorkplace(@RequestParam Integer id) {
        WorkplaceDto workplaceById = service.getWorkplaceById(id);
    }

    @DeleteMapping("/workplace_page")
    public void deleteWorkplaceById(@RequestParam Integer id) {
        service.deleteWorkplaceById(id);
    }

    @PutMapping("/workplace_page")
    public void updateWorkplaceById(@Valid WorkplaceDto workplace, @RequestParam Integer id) {
        service.updateWorkplaceById(workplace, id);
    }

    @PostMapping("/add_worker_to_workplace")
    public void addWorkerToWorkplace(@RequestParam Integer workerId, @RequestParam Integer workplaceId) {

        service.addWorkerToWorkplace(workerId, workplaceId);

    }

    @DeleteMapping("/remove_worker_to_workplace")
    public void removeWorkerFromWorkplace(@RequestParam Integer workerId, @RequestParam Integer workplaceId) {

        service.removeWorkerFromWorkplace(workerId, workplaceId);

    }

}
