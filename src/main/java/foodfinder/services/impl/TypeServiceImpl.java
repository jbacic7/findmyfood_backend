package foodfinder.services.impl;

import foodfinder.dto.Type;
import foodfinder.repository.TypeRepository;
import foodfinder.services.interfaces.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Override
    public List<Type> fetchTypeList() {

        return typeRepository.findAll();
    }

}
