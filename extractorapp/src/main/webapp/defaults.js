Ext.namespace("GEOR", "GEOR.data");

Ext.apply(GEOR.data, {
   services: [{
        text: "geobretagne.fr WMS NS=geob",
        owstype: "WMS",
        owsurl: "http://geobretagne.fr/geoserver/wms?NAMESPACE=geob"
    }, {
        text: "drebretagne WFS",
        owstype: "WFS",
        owsurl: "http://install.georchestra.org/geoserver/wfs"
    }],
    layers: [{
        owstype: "WMS",
        owsurl: "http://geolittoral.application.equipement.gouv.fr/wms/metropole",
        layername: "Sentiers_littoraux"
    }, {
        owstype: "WMS",
        owsurl: "http://install.georchestra.org/geoserver/wms",
        layername: "geob:communes_geofla"
    }, {
        owstype: "WFS",
        owsurl: "http://install.georchestra.org/geoserver/wfs",
        layername: "geob:communes_geofla"
    }, {
        owstype: "WMS",
        owsurl: "http://install.georchestra.org/geoserver/wms",
        layername: "geob:SC1000_0050_7130_L93"
    }]
});