new Test (args) {
  var queryParams = Map(
    "bbox" -> "-4.614646073422986,-42.851001816890005,147.2910004483,47.74552119985795",
    "Format" -> "image/png",
    "request" -> "GetMap",
    "layers" -> "geob_test:tasmania_cities",
    "width" -> "550",
    "height" -> "250",
    "srs" -> "EPSG:4326")
  "wms getmap" inService "geoserver/wms" withGet queryParams should (result => {

    // for mode="mixed"
    //result has ('responseCode -> 401) 

    // for mode="hide"
    val ok = (result.xml \\ "ServiceException").first.text contains "java.util.NoSuchElementException"
    assert(ok, "did not get a NoSuchElementException")
  })
}