package ro.msg.learning.shop.DTOs;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

public class LocationDTO implements Serializable{
    private Integer id;
    private String name;
    private AddressDTO addressDTO;
}
