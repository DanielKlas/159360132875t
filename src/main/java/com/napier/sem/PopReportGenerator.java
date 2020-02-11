package com.napier.sem;

public class PopReportGenerator {

    //TODO: Add world, district and city report
    private String generalPopQuery;
    public PopReportGenerator()
    {
        generalPopQuery=
                "SELECT country.%s, sum(country.population) as 'Total Population', " +
                        "sum(city.population) as 'Urban Population', " +
                        "sum(city.Population) / sum(country.Population) as 'UrbanPercent', " +
                        "sum(country.Population) - sum(city.population) as 'Rural Population', " +
                        "(sum(country.population) - sum(city.population))/ sum(country.population) as 'RuralPercent' " +
                        "FROM country JOIN city ON country.Code=city.CountryCode " +
                        "WHERE country.%s LIKE %s GROUP BY country.%s;";
    }

    public String getQuery(String queryVar, String name)
    {
        String newQuery = String.format(generalPopQuery,queryVar,queryVar,name,queryVar);
        return newQuery;
    }
}
