package service.country;

import model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ICountryRepository;

public class CountryService implements ICountryService {

    @Autowired
    private ICountryRepository countryService;

    @Override
    public Iterable<Country> findAll() {
        return countryService.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryService.findOne(id);
    }

    @Override
    public void update(Country model) {
        countryService.save(model);
    }

    @Override
    public void save(Country model) {
        countryService.save(model);
    }

    @Override
    public void remove(Long id) {
        countryService.delete(id);
    }
}
