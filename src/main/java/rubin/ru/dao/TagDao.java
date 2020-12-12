package rubin.ru.dao;

import rubin.ru.model.Tag;
import java.util.List;

public interface TagDao {

    List<Tag> getTags();

    Long save(Tag tag);

    Long update(Long tagId, Tag tag);

    Long delete(Long tagId);

}
