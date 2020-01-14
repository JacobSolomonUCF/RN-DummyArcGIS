//  Created by react-native-create-bridge

import React from 'react'
import { NativeEventEmitter, Platform, requireNativeComponent, NativeModules,  UIManager, findNodeHandle, DeviceEventEmitter } from 'react-native'
import PropTypes from 'prop-types'
const AGSMap = requireNativeComponent('RNArcGISMapView', ArcGISMapView);


class ArcGISMapView extends React.Component {
  constructor(props) {
    super(props);
    var eventEmitter;
    if (Platform.OS === 'ios') {
      eventEmitter = new NativeEventEmitter(NativeModules.RNArcGISMapViewModule);
    } else {
      eventEmitter = DeviceEventEmitter;
    }
  }
  // MARK: Render
  render () {
    return <AGSMap {...this.props} ref={e => this.agsMapRef = e} />
  }

  // MARK: Disposal
  componentWillUnmount() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.agsMapRef),
      UIManager.getViewManagerConfig('RNArcGISMapView').Commands.dispose,
      [args]
    );
  }
}

export default ArcGISMapView;
