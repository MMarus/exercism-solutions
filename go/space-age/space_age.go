package space

type Planet string

var secondsInOneEarthYear = 31557600.0
var orbitalPeriodsInEarthYears = map[Planet]float64{
	"Earth":   secondsInOneEarthYear*1.0,
	"Mercury": secondsInOneEarthYear*0.2408467,
	"Venus":   secondsInOneEarthYear*0.61519726,
	"Mars":    secondsInOneEarthYear*1.8808158,
	"Jupiter": secondsInOneEarthYear*11.862615,
	"Saturn":  secondsInOneEarthYear*29.447498,
	"Uranus":  secondsInOneEarthYear*84.016846,
	"Neptune": secondsInOneEarthYear*164.79132,
}


func Age(seconds float64, planet Planet) float64 {
	return seconds / orbitalPeriodsInEarthYears[planet]
}
