import React from 'react'
import { connect } from 'react-redux';
import CardDesks from '../CardDesk/CardDesk.css'
import * as DeskService from '../DeskService/DeskService.js'; //import semua yg ada di userlist
import { Button } from '@material-ui/core';
class ListDesk extends React.Component {
    //componentDidMount
    loadDesk() {
        console.log('loaddesk');
        const { dispatch } = this.props;

        dispatch({ type: 'FETCH_DESKS' });
        DeskService.listDesk()
            .then((desks) => {
                // const { data : foods }= response;
                dispatch({ type: 'FETCH_DESKS_DONE', loading: false, desks })
                
            })
            .catch((error) => {
                dispatch({ type: 'FETCH_DESKS_DONE', loading: false, desks: [] });
            });
    }

    componentDidMount() {
        console.log('CDM DESK')
        if (this.props.loading) {
            this.loadDesk();
        }
    }


    renderDesksRows(desks) {
        return desks.map((desk) => {
          

            return (
                <div className="wrapdesk">
                    <div className="carddesk" >
                        <p key={desk.id}>
                            <p className="detaildesk" >{desk.name}</p>
                            <p className="detaildesk">{desk.capacity} Capacity</p>
                            <p className="detaildesk">{desk.status}</p>
                        </p>
                        <button onClick={e => this.props.dispatch({type: 'FETCH_DESK', desk})}>Add</button>
                    </div>
                </div>

            );
        });
    }
    render() {
        console.log('renderdesks')
        const { desks, loading } = this.props;
        let rows = (<font color="black">LOADING...</font>);

        if (!loading) {
            rows = this.renderDesksRows(desks);
        }


        return (
            <div>
                {/*                 
                <button className="button" onClick={()=> this.foods()}>Reload</button> */}
                <div>


                    {rows}

                </div>


            </div>
        );
    }
}

function mapStateToProps(state) {
    return { ...state.Desk };
}
export default connect(mapStateToProps)(ListDesk);