import {queryHot} from '../services/hot'
import {addCollect} from "../services/collect";
import {routerRedux} from "dva/router";

export default {
  namespace: 'hots',
  state: {
    hotItem: [],
    showMessage:'添加收藏',
    disabled:false
  },
  reducers: {
    queryHotToState(state, {payload}) {
      //console.log(state.showMessage)
      state.hotItem = payload;
      return {...state}
    },
    modifyButtonState(state){
      console.log('modifyButtonStatesdsadads')
      console.log(state)
      return {...state}
    }
  },
  effects: {
    * queryHot({payload}, {put, call}) {
      const result = yield call(queryHot);
      console.log(result)
      if (result) {
        yield put({
          type: 'queryHotToState',
          payload: result
        })
      }
    },
    * addCollect({payload}, {put, call}) {
      console.log(payload.count)
      yield call(addCollect,payload.id,payload.userid,payload.count);
      // yield put({
      //   type: 'queryHot',
      // })
      yield put(routerRedux.push('/collect'));
    }
  },
  subscriptions: {
    setup({dispatch, history}) {
      history.listen(location => {
        if (location.pathname === '/hot') {
          dispatch({
            type: 'queryHot'
          });
        }
      });
    },
  },
}
