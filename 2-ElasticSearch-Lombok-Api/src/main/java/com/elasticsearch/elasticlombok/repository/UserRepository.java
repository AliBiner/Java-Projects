package com.elasticsearch.elasticlombok.repository;

import com.elasticsearch.elasticlombok.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Repository olarak etiketlediğimiz için injection işlemimiz daha rahat olur ama yeni sürümlerde etiketlemesekte extends edilmiş sınfımız sayesinde injection işlemi kolaca yapılabilir.
public interface UserRepository extends ElasticsearchRepository<User,String> {
    @Query("{\"bool\":{\"must\": [{\"match\": {\"name\":\"?0\"}}]}}") //elasticsearch için qeuery annotation ile sorgu dönüştürülebilir.
    List<User> getByCustomQuearyAsync(String search);

    //Spring data'nın sunduğu bir yöntem olan fonksiyon adıyla da query oluşturulabilir.
    List<User> findByNameContainsOrSurnameContains(String name, String surname);


}
