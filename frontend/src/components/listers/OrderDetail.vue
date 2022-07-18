<template>
    <v-card outlined>
        <v-card-title>
            Order # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="RentalId" v-model="item.rentalId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PurifierId" v-model="item.purifierId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RentalStatus" v-model="item.rentalStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PurifierRentalPrice" v-model="item.purifierRentalPrice" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/orders/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
