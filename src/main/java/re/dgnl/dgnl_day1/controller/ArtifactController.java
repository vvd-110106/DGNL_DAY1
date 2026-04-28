package re.dgnl.dgnl_day1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import re.dgnl.dgnl_day1.model.Artifact;
import re.dgnl.dgnl_day1.service.IArtifactService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ArtifactController {

    private final IArtifactService artifactService;

    @GetMapping("/")
    public String list (
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC)Pageable pageable,
            @RequestParam(name = "search", defaultValue = "") String search,
            Model model
            ) {
        model.addAttribute("artifacts", artifactService.getAllArtifacts(search, pageable));
        model.addAttribute("search", search);
        return "meseum";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("artifact", new Artifact());
        return "form";
    }

    @PostMapping("/save")
    public String save(
            @Valid
            @ModelAttribute Artifact artifact,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "form";
        }
        artifactService.save(artifact);
        redirectAttributes.addFlashAttribute("message", "Thành công");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Long id,
            Model model
    ) {
        model.addAttribute("artifact",artifactService.findById(id));
        return "form";
    }
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {
        artifactService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/";
    }
}
