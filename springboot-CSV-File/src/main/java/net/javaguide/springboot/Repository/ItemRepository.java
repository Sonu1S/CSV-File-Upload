package net.javaguide.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguide.springboot.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
