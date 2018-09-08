import {queryCollect,deleteCollect} from '../services/collect'
export default {
  namespace: 'collects',
  state: {
    collectList: []
  },
  reducers: {
    queryCollectSuccess(state,{payload:{data}}) {
      state.collectList=data
      return {...state}
    },
  },
  effects: {
    * queryCollect(payload, {put, call}) {
      const result = yield call(queryCollect);
      console.log(result)
      if (result) {
        yield put({
          type: 'queryCollectSuccess',
          //payload: result.data
          payload: result
        });
      }
    },
    * deleteCollect({payload}, {put, call}) {
      console.log(payload)
      yield call(deleteCollect,payload);
      yield put({
        type: 'queryCollect',
      });
    },
  },
  subscriptions: {
    setup({dispatch, history}) {
      history.listen(location => {
        if (location.pathname === '/collect') {
          dispatch({
            type: 'queryCollect',
          });
        }
      });
    },
  },
}
