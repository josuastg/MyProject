import React, { Component } from 'react';
import { View, StyleSheet, Text, TouchableOpacity, ScrollView, Animated } from 'react-native';
import { Avatar, Header, Button } from 'react-native-elements';
import * as Service from '../services/ContactService.js';
import { FETCH_DETAIL_USER_SUCCESS, FETCH_DETAIL_USER_ERROR } from '../action/Contact.js';
import { Spinner } from 'native-base';
import { connect } from 'react-redux';
import { FAB } from 'react-native-paper';

class DetailPersonScreen extends Component {

    detailContact() {
        const { dispatch } = this.props;
        const id = this.props.navigation.getParam('id');
        Service.detailContact(id)
            .then((data) => {
                dispatch({ type: FETCH_DETAIL_USER_SUCCESS, loading: false, data: data })
            }).catch((error) => {
                dispatch({ type: FETCH_DETAIL_USER_ERROR, loading: false, error: error })
            })

    }
    handleDelete = () => {
        const id = this.props.navigation.getParam('id');
        Service.deleteContact(id)
        this.props.navigation.navigate('HomeScreen');

    }

    componentDidMount() {
        this.detailContact();
    }
    render() {
        const { data } = this.props;
        return (
            <>
                <ScrollView>
                    <View >
                        {data ?
                            <View >
                                <Header
                                    statusBarProps={{ barStyle: 'light-content' }}
                                    barStyle="light-content"
                                    centerComponent={{ text: 'DETAIL CONTACT', style: { color: '#fff', fontSize: 20, fontWeight: 'bold' } }}
                                    containerStyle={{
                                        backgroundColor: '#00BFFF',
                                        justifyContent: "space-around"
                                    }}
                                />
                                <View style={{ alignItems: 'center', marginTop: 50 }}>
                                    <Avatar
                                        rounded
                                        size="xlarge"
                                        source={{
                                            uri:
                                                data.photo,
                                        }}
                                    />
                                </View>
                                <View style={{ marginTop: 40 }}>

                                    <View style={{ padding: 2 }}>
                                        <TouchableOpacity>
                                            <View style={{ margin: 20 }}>
                                                <Text style={styles.textDetailTitle}>
                                                    Firstname
                                          </Text>
                                                <Text style={styles.textDetail}>{data.firstName}</Text>
                                            </View>
                                        </TouchableOpacity>
                                        <TouchableOpacity>
                                            <View style={{ margin: 20 }}>
                                                <Text style={styles.textDetailTitle}>
                                                    Lastname
                                          </Text>
                                                <Text style={styles.textDetail}>{data.lastName}</Text>
                                            </View>
                                        </TouchableOpacity>
                                        <TouchableOpacity>
                                            <View style={{ margin: 20 }}>
                                                <Text style={styles.textDetailTitle}>
                                                    Age
                                          </Text>
                                                <Text style={styles.textDetail}>{data.age}</Text>
                                            </View>
                                        </TouchableOpacity>
                                    </View>
                                </View>
                            </View> : <Spinner color="black" />}
                    </View>
                </ScrollView>

                <FAB
                    style={styles.fab}
                    big
                    color="#FFF"
                    onPress={() => { this.props.navigation.navigate('UpdatePersonScreen') }}
                    icon="pencil"></FAB>

                <FAB
                    style={styles.fabTwo}
                    small
                    color="#FFF"
                    onPress={this.handleDelete}
                    icon="delete"></FAB>
            </>

        );
    }
}

function mapStateToProps(state) {
    return { ...state.findDetailContact }

}
export default connect(mapStateToProps)(DetailPersonScreen);

const styles = StyleSheet.create({
    header: {
        backgroundColor: '#00BFFF',
        position: 'absolute',
        width: '100%',
        zIndex: 9999
    },
    textDetail: {
        fontSize: 18,
        marginTop: 10
    },
    textDetailTitle: {
        fontSize: 23,
        fontWeight: 'bold'

    },
    fab: {
        position: 'absolute',
        backgroundColor: "#00BFFF",
        margin: 16,
        right: 0,
        bottom: 0,
    },
    fabTwo: {
        backgroundColor: '#FF0000',
        position: 'absolute',
        margin: 85,
        marginRight: 25,
        right: 0,
        bottom: 0,
    }
}) 