/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import ArcGISMapView from './AGSMapView';
// import ArcGISMapView from 'react-native-arcgis-mapview';


const App: () => React$Node = () => {
  return (
    <View style={{flex: 1}}>
      <Text>CAN YOU SEE THE MAP?</Text>
      <ArcGISMapView
        ref={mapView => this.mapView = mapView}
        style={styles.root}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  root: {
    position: 'absolute',
    top: 100,
    right: 0,
    left: 0,
    bottom: 0,
    zIndex: 1,
  }
});

export default App;
