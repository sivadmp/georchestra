Version 13.02
=============

This new release was made possible thanks to support from the French GIP ATGeRi (http://cartogip.fr/) and contributors.

New features:
 * mapfishapp: lon, lat and radius GET parameters for startup recentering, see https://github.com/georchestra/georchestra/pull/20
 * mapfishapp: switchable pointer coordinates SRS, see https://github.com/georchestra/georchestra/pull/25
 * mapfishapp: layers drag'n drop in layer manager, see http://applis-bretagne.fr/redmine/issues/1959
 * mapfishapp: OGC context switcher, see https://github.com/georchestra/georchestra/pull/26
 * mapfishapp: print layouts ACL, see https://github.com/georchestra/georchestra/pull/30
 * mapfishapp: spatial query based on a circle, see http://applis-bretagne.fr/redmine/issues/1957
 * geoserver: useful extensions added in template profile, see http://applis-bretagne.fr/redmine/issues/4217
 * extractorapp: extraction bbox is now part of the data bundle, see https://github.com/georchestra/georchestra/pull/35
 * mapfishapp: support for addons & magnifier addon, see https://github.com/georchestra/georchestra/pull/36
 * mapfishapp: cadastre addon, see https://github.com/georchestra/georchestra/pull/48

Enhancements:
 * mapfishapp: results panel displays URLs as html links, see https://github.com/georchestra/georchestra/pull/21
 * mapfishapp: add layer from thesaurus: metadata title first, see https://github.com/georchestra/georchestra/pull/23
 * mapfishapp: more visible layer names, see https://github.com/georchestra/georchestra/pull/22
 * mapfishapp: add zoomout button in the toolbar, see https://github.com/georchestra/georchestra/pull/24
 * mapfishapp: added ability to print protected geoserver layers, see https://github.com/georchestra/template/commit/bb424bd74f7504af93b5e5c708f807ce0b6fdca4
 * mapfishapp: more robust detection of WMS layers in CSW getRecords responses, see https://github.com/georchestra/georchestra/pull/4
 * mapfishapp: window buttons consistency and default actions, see https://github.com/georchestra/georchestra/pull/33
 * mapfishapp: by default, the map is now restored with its latest known state (context), see https://github.com/georchestra/georchestra/pull/50
 * mapfishapp: missing translations

Bug fixes:
 * mapfishapp: fixed erroneous WMSC2WMS mapping, which prevented printing of the GeoBretagne OSM baselayer, see https://github.com/georchestra/georchestra/commit/159bd4f24ecb21b9c76f76d27c1736ec1040f0ab
 * mapfishapp: use toponymName instead of name in GeoNames results, see https://github.com/georchestra/georchestra/issues/45

UPGRADING:
 * mapfishapp config changes (see GEOR_config.js or GEOR_custom.js for more information):
    * MAP_POS_SRS1 and MAP_POS_SRS2 options have been replaced with POINTER_POSITION_SRS_LIST
    * DEFAULT_WMC option has been replaced with CONTEXTS
    * PRINT_LAYOUTS_ACL allows to fine-tune available printing layouts based on user roles
    * DEFAULT_PRINT_FORMAT is now replaced by DEFAULT_PRINT_LAYOUT
 * In GeoNetwork, it is now recommended to use OGC:WMS protocol rather than OGC:WMS-1.1.1-http-get-map (or any other WMS tagged with a version) to declare WMS layers, see https://github.com/georchestra/georchestra/pull/4
