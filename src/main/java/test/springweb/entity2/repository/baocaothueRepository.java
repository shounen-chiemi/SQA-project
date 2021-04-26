package test.springweb.entity2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.springweb.entity2.*;

import java.util.List;

public interface baocaothueRepository extends JpaRepository<baocaothue,Integer> {
    @Query(value = "select * from baocaothue", nativeQuery = true)
    Page<baocaothue> getDsBaocaothue(Pageable pageable);

    @Query(value = "select * from baocaothue", nativeQuery = true)
    List<baocaothue> getDsBaocaothue();
}
