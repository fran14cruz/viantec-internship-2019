package rubin.ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import rubin.ru.model.Tag;
import rubin.ru.service.TagService;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping(value = "/tag")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @PostMapping(value = "/tag")
    public Long createTag(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PutMapping(value = "/tag/{tagId}")
    public Long updateTag(@PathVariable Long tagId, @RequestBody Tag tag) {
        return tagService.update(tagId, tag);
    }

    @DeleteMapping(value = "/tag/{tagId}")
    public Long deleteTag(@PathVariable Long tagId) {
        return tagService.delete(tagId);
    }

}
