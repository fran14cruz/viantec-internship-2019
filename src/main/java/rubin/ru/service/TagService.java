package rubin.ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rubin.ru.dao.TagDao;
import rubin.ru.model.Tag;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    public List<Tag> getTags() {
        return tagDao.getTags();
    }

    public Long save(Tag tag) {
        return tagDao.save(tag);
    }

    public Long update(Long tagId, Tag tag) {
        return tagDao.update(tagId, tag);
    }

    public Long delete(Long tagId) {
        return tagDao.delete(tagId);
    }

}