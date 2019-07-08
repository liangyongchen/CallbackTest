/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    Platform,
    StyleSheet,
    Text,
    View,
    TouchableOpacity
} from 'react-native';

const instructions = Platform.select({
    ios: 'Press Cmd+R to reload,\n' +
    'Cmd+D or shake for dev menu',
    android: 'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

import FileUploadUtil from './src/utils/FileUploadUtil'

type Props = {};
export default class App extends Component<Props> {

    constructor(props) {
        super(props)

        changeText = ''
        this.state = {}
    }

    componentDidMount() {
        FileUploadUtil.start(this.onCallback.bind(this))
    }

    async onCallback(type, code, msg) {
        this.changeText += '\t\n' + msg
        this.setState({})
    }

    componentWillUnmount() {
        FileUploadUtil.stop()
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.welcome}>
                    回调接口
                </Text>
                <TouchableOpacity onPress={() => {
                    this.changeText = ''
                    FileUploadUtil.start(this.onCallback.bind(this))
                }}>
                    <Text>{'重试'}</Text>
                </TouchableOpacity>
                <Text style={styles.instructions}>
                    {this.changeText}
                </Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});
