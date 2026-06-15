package org.example.restApi;

import org.example.ICityService;

import java.util.List;

@RestController //Api kontrolü
@RequestMapping("/api") // bu operasyondaki her şey api ile başlayacak demek


public class CityController {
    private ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities") //ben veritabanında değişiklik yapmak istemiyorum bana verileri getir
    public List<City> get(){
        return cityService.getAll();

    }

    @PostMapping("/add")
    public void add(@RequestBody City city){
        cityService.add(city);
    }

    @PostMapping("/update")
    public void add(@RequestBody City city){
        cityService.add(city);
    }

    @PostMapping("/delete")
    public void add(@RequestBody City city){
        cityService.add(city);
    }


    @GetMapping("/cities/{id}") //cities' e bir parametre yollamamız gerekiyor örneği /cities/1 gibi fakat bu dinamik olduğu için {id} şeklinde bir parametre istiyorum anlamında yazılır
    public City getById(@PathVariable int id){
            return cityService.getById(id);
        }

    }

