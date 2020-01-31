import React, { Component } from 'react';
import { View, Text, ScrollView, RefreshControl, StyleSheet, ImageBackground, TouchableHighlight } from 'react-native';
import { Header } from 'react-native-elements';
import { connect } from 'react-redux'
import { FETCH_ALL_USERS, FETCH_ALL_USERS_ERROR, FETCH_ALL_USERS_SUCCESS } from '../action/Contact.js';
import * as Service from '../services/ContactService';
import { Searchbar } from 'react-native-paper';
import { createFilter } from 'react-native-search-filter';
import { FlatGrid } from 'react-native-super-grid';
import { Spinner } from 'native-base';
import { FAB } from 'react-native-paper';
const KEY_TO_FILTER = ['firstName', 'lastName']
class HomeScreen extends Component {
    constructor(props) {
        super(props);
        this.state = {
            keyword: ''
        }
    }

    searchPerson = (key) => {
        this.setState({ keyword: key })
    }

    listContacts() {
        const { dispatch, loading } = this.props;
        if (!loading) {
            dispatch({ type: FETCH_ALL_USERS, data: [], loading: true });
            Service.list()
                .then(data => {
                    dispatch({ type: FETCH_ALL_USERS_SUCCESS, loading: false, data: data });
                })
                .catch((error) => {
                    dispatch({ type: FETCH_ALL_USERS_ERROR, loading: false, data: [], error: error });
                })
        }
    }

    componentDidMount() {
        this.listContacts();
    }

    reload = () => {
        this.listContacts();
    }
    render() {

        const { loading, data } = this.props;
        const filterPerson = data.filter(createFilter(this.state.keyword, KEY_TO_FILTER)).sort((a, b) => {
            let peopleA = a.firstName.toUpperCase();
            let peopleB = b.firstName.toUpperCase();
            return (peopleA < peopleB) ? -1 : peopleA > peopleB ? 1 : 0
        })
        const items = filterPerson;
        return (
            <>
                <View style={{ backgroundColor: '#F5F5F5', marginBottom: 130 }}>
                    <View>
                        <Header
                            statusBarProps={{ barStyle: 'light-content' }}
                            barStyle="light-content"
                            centerComponent={{ text: 'MY CONTACT', style: { color: '#fff', fontSize: 20, fontWeight: 'bold' } }}
                            containerStyle={{
                                backgroundColor: '#00BFFF',
                                justifyContent: 'center',
                            }}
                        />
                        <View style={styles.searchStyle}>
                            <Searchbar placeholder="Search person..."
                                onChangeText={(key) => { this.searchPerson(key) }}
                            />
                        </View>
                        <ScrollView refreshControl={<RefreshControl refreshing={loading} onRefresh={this.reload} />} >
                            {!loading ?
                                <FlatGrid
                                    itemDimension={130}
                                    items={items}
                                    style={styles.gridView}
                                    renderItem={({ item, index }) => (
                                        <TouchableHighlight onPress={() => { this.props.navigation.navigate('DetailPersonScreen', { id: item.id }) }} underlayColor="#00BFFF">
                                            <View >
                                                <ImageBackground
                                                    style={[styles.itemContainer]}
                                                    source={{ uri: item.photo }}>
                                                    <Text style={styles.itemName}>{item.firstName}</Text>
                                                </ImageBackground>
                                            </View>
                                        </TouchableHighlight>
                                    )}
                                />
                                : <Spinner color="blue" />}
                        </ScrollView>

                    </View>
                </View>
                <FAB
                    style={styles.fab}
                    big
                    backgroundColor="blue"
                    color="#FFF"
                    onPress={() => { this.props.navigation.navigate('CreatePersonScreen') }}
                    icon="plus"></FAB>

            </>
        );
    }
}

const styles = StyleSheet.create({
    searchStyle: {
        padding: 8
    },
    fab: {
        position: 'absolute',
        backgroundColor: "#00BFFF",
        margin: 16,
        right: 0,
        bottom: 0,
    },
    gridView: {
        marginTop: 20,
        flex: 1,
    },
    itemContainer: {
        justifyContent: 'flex-end',
        borderRadius: 20,
        padding: 10,
        height: 150,
    },
    itemName: {
        fontSize: 20,
        color: '#FFF',
        fontWeight: 'bold',
        textShadowColor: '#00BFFF'
    },
    itemCode: {
        fontWeight: 'bold',
        fontSize: 18,
        color: '#BBB',
    },
})

function mapStateToProps(state) {
    return { ...state.findAllContact }
}

export default connect(mapStateToProps)(HomeScreen);