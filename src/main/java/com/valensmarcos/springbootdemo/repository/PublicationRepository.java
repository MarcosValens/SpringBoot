package com.valensmarcos.springbootdemo.repository;

import com.valensmarcos.springbootdemo.entity.Publication;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicationRepository extends CrudRepository<Publication,Long> {
    /*SOLO LAS CONSULTAS QUE SALGAN DE LO ESTANDARD*/

    Publication findAllByTitleContainsAndObservationsNotNull(String title);

    /*@Query(nativeQuery = true, value = "SELECT * FROM publicacio WHERE contingut=:contingut")*/
    @Query("FROM Publication WHERE content=:contingut")
    Publication findEspecific(String contingut);

    List<Publication> findAllByTitleContainsAndContentContains(String title, String content);

}
