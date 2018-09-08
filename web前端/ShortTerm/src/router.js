import React from 'react';
import { Router, Route, Switch } from 'dva/router';
import HomePage from './routes/HomePage/Login';
import Search from './routes/Search/Search';
import Sort from './routes/Sort/Sort';
import Online from './routes/Online/Online';
import Hot from './routes/Hot/Hot';
import Knowledge from './routes/Knowledge/Knowledge'
import Collect from './routes/Collection/Collect'
import Share from './routes/Share/Share'
import AddKnowledge from './routes/Knowledge/AddKnowlege'

function RouterConfig({ history }) {
  return (
    <Router history={history}>
      <Switch>
        <Route path="/" exact component={HomePage} />
        <Route path="/search" exact component={Search} />
        <Route path="/sort" exact component={Sort} />
        <Route path="/online" exact component={Online} />
        <Route path="/hot" exact component={Hot} />
        <Route path="/knowledge" exact component={Knowledge} />
        <Route path="/addknowledge" exact component={AddKnowledge} />
        <Route path="/collect" exact component={Collect} />
        <Route path="/share" exact component={Share} />
      </Switch>
    </Router>
  );
}

export default RouterConfig;
