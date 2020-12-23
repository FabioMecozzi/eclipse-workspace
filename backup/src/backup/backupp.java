import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.ddgfm.ProgettoOOP.controller.Filter;
import com.ddgfm.ProgettoOOP.model.City;
import com.ddgfm.ProgettoOOP.model.Configuration;
import com.ddgfm.ProgettoOOP.model.Settings;
import com.ddgfm.ProgettoOOP.model.Statistics;
import com.ddgfm.ProgettoOOP.service.UVService;

/**
	 * Rotta per ottenere la chiave utente
	 * @return la chiave
	 */
	@GetMapping("/getKey")
	public String key() {
		String responseString="";
		
		//da implementare
		
		return responseString;
		
	}
	/**
	 * Rotta per modificare le impostazioni di default dell'utente
	 * @param newSettings nuove impostazioni dell'utente
	 * @param key chiave dell'utente
	 * @return un messaggio che risponde se le impostazioni sono state modificate con successo
	 */
	@PostMapping("/settings")
	public String ChangeSettings(@RequestBody Settings newSettings, @RequestParam(name="key", required = true) String key) {
		String responseString;
		try {
			UVService.ChangeSettings(newSettings, key);
			responseString="Settings successfully changed";
		} catch (BadRequest e) {
			responseString= e.getMessage();
		} 
		return responseString;
	}
	
	/**
	 * Rotta per ottenere le impostazioni personalizzate dall'utente
	 * @param key chiave dell'utente
	 * @return le impostazioni dell'utente
	 */
	@GetMapping("/settigs")
	public Settings getSettings(@RequestParam(name="key", required = true) String key) {
		return UVService.getSettings(key);
		
	}

	/**
	 * Rotta per ottenere i dati dei raggi UV attuali o di forecasting
	 * @param forecastingDays numero di giorni per i quali si vuole la  previsione (max 7 giorni), se uguale a zero (valore di default) si stanno richiedendo i dati attuali 
	 * @param arrayToPopulate Body contenente l'array di città per le quali si vogliono conoscere i dati
	 * @return array passato nel body popolato dai valori dei raggiu uv
	 */
	@GetMapping("/GetData")
	public ArrayList<City> GetData(@RequestBody ArrayList<City> arrayToPopulate, @RequestParam(name="forecastingDays", defaultValue = "0") int forecastingDays ){

		//da implementare
		
		return arrayToPopulate;
	}
	
	/**
	 * Rotta per ottenere le statistiche
	 * @param filter filtri da applicare alle statistiche
	 * @param key chiave per usare filtri di default
	 * @return statistiche filtrate
	 */
	@GetMapping("/GetStatistics")
	public Statistics GetStatistics(@RequestBody Filter<Integer> filter, @RequestParam(name="key") String key){ //filter da modificare, completare dopo aver studiato la classe filter della libreria standars
		
		//da implementare
		
		return new Statistics();
	}
	

	@PostMapping("/setConfiguartion")
	public String setConfiguration(@RequestBody Configuration newConfig, @RequestParam(name="key", required = true) String adminKey) {
		return(""); //da implementare
	}
