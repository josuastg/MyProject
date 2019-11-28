import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Set from './setupTests.js';
import Header from './Component/Header/Header.jsx';
import { shallow } from 'enzyme';


describe('App', () => {
  it('should have one Provider', () => {
    const appProvider = shallow(<App />)
    expect(appProvider.find('Provider')).toHaveLength(1)
  });

  it('should have one Switch', ()=>{
    const appRouter = shallow(<App/>)
    expect(appRouter.find('Switch')).toHaveLength(1)
  })
  it('should have one SideBar', ()=>{
    const appSideBar= shallow(<App/>)
    expect(appSideBar.find('SideBar')).toHaveLength(1)
    
  })
  it('should have one main', ()=>{
    const appMain = shallow(<App/>)
    expect(appMain.find('main')).toHaveLength(1)
  })
})


